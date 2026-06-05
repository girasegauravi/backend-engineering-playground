package com.distributedsystems.consistenthashing;

import java.util.*;

/**
 * Consistent Hashing Ring with dynamic ADD, REMOVE, and ASSIGN operations.
 * <p>
 * Core idea:
 * - Servers and keys are mapped to a ring of 0-359 degrees.
 * - A key is assigned to the nearest server clockwise.
 * - If multiple servers exist at the same location, latest added server serves future requests.
 * <p>
 * Existing keys are sticky:
 * - ADD at existing location does not move old keys.
 * - REMOVE only moves keys currently assigned to removed server.
 */
public class ConsistentHashingRing {

    private static final int RING_SIZE = 360;

    public int[] solve(String[] A, String[] B, int[] C) {
        int n = A.length;
        int[] ans = new int[n];

        TreeMap<Integer, Deque<String>> ring = new TreeMap<>();
        Map<String, Integer> serverToLoc = new HashMap<>();

        Map<String, Integer> keyToHash = new HashMap<>();
        Map<String, String> keyToServer = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String op = A[i];
            String name = B[i];

            if (op.equals("ADD")) {
                int loc = userHash(name, C[i]);

                boolean locationAlreadyExists = ring.containsKey(loc);
                String activeSuccessorBeforeAdd = null;

                if (!ring.isEmpty() && !locationAlreadyExists) {
                    Integer successorLoc = ring.ceilingKey(loc);
                    if (successorLoc == null) {
                        successorLoc = ring.firstKey();
                    }
                    activeSuccessorBeforeAdd = ring.get(successorLoc).peekLast();
                }

                ring.putIfAbsent(loc, new ArrayDeque<>());
                ring.get(loc).addLast(name);
                serverToLoc.put(name, loc);

                int reassigned = 0;

                if (!locationAlreadyExists) {
                    for (String key : keyToHash.keySet()) {
                        String oldServer = keyToServer.get(key);
                        String newServer = findAssignedServer(ring, keyToHash.get(key));

                        if (newServer.equals(name) && Objects.equals(oldServer, activeSuccessorBeforeAdd)) {
                            keyToServer.put(key, name);
                            reassigned++;
                        }
                    }
                }

                ans[i] = reassigned;
            }

            else if (op.equals("REMOVE")) {
                String server = name;

                int count = 0;
                for (String assignedServer : keyToServer.values()) {
                    if (Objects.equals(assignedServer, server)) {
                        count++;
                    }
                }

                ans[i] = count;

                int loc = serverToLoc.get(server);
                Deque<String> serversAtLoc = ring.get(loc);
                serversAtLoc.remove(server);

                if (serversAtLoc.isEmpty()) {
                    ring.remove(loc);
                }

                serverToLoc.remove(server);

                for (String key : keyToHash.keySet()) {
                    if (Objects.equals(keyToServer.get(key), server)) {
                        keyToServer.put(key, findAssignedServer(ring, keyToHash.get(key)));
                    }
                }
            }

            else { // ASSIGN
                int keyHash = userHash(name, C[i]);

                String server = findAssignedServer(ring, keyHash);
                int serverLoc = serverToLoc.get(server);

                keyToHash.put(name, keyHash);
                keyToServer.put(name, server);

                ans[i] = serverLoc;
            }
        }

        return ans;
    }

    private String findAssignedServer(TreeMap<Integer, Deque<String>> ring, int keyHash) {
        Integer loc = ring.ceilingKey(keyHash);

        if (loc == null) {
            loc = ring.firstKey();
        }

        return ring.get(loc).peekLast();
    }

    private int userHash(String username, int hashKey) {
        int hashCode = 0;
        long pPow = 1;

        for (int i = 0; i < username.length(); i++) {
            char ch = username.charAt(i);
            hashCode = (int) ((hashCode + (ch - 'A' + 1) * pPow) % RING_SIZE);
            pPow = (pPow * hashKey) % RING_SIZE;
        }

        return hashCode;
    }
}
