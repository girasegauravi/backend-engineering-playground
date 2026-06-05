package com.distributedsystems.consistenthashing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Test Suite for ConsistentHashingRing.
 *
 * Key Invariants Verified:
 *
 * 1. Ring topology != key ownership.
 *
 * 2. Existing keys are sticky.
 *    Keys are not globally recomputed after every change.
 *
 * 3. ADD at new location:
 *    Steals only affected keys from successor interval.
 *
 * 4. ADD at existing location:
 *    Does not move existing keys.
 *    Affects only future assignments.
 *
 * 5. REMOVE:
 *    Reassigns only keys currently owned by removed server.
 *
 * 6. Multiple servers at same location:
 *    Latest added server serves future requests.
 */
public class ConsistentHashingRingTest {

    /**
     * Validates the sample test case from the problem statement.
     *
     * Scenario:
     * 1. Add INDIA.
     * 2. Assign a key.
     * 3. Add RUSSIA.
     * 4. Verify previously assigned key gets reassigned
     *    according to consistent hashing rules.
     * 5. Remove INDIA.
     * 6. Verify assignments continue correctly.
     *
     * Concepts Tested:
     * - Clockwise server lookup
     * - Key reassignment after server addition
     * - Wrap-around behavior
     * - Server removal
     */
    @Test
    void testBasicExampleOne() {
        ConsistentHashingRing solution = new ConsistentHashingRing();

        String[] A = {"ADD", "ASSIGN", "ADD", "ASSIGN", "REMOVE", "ASSIGN"};
        String[] B = {"INDIA", "NWFJ", "RUSSIA", "OYVL", "INDIA", "IGAX"};
        int[] C = {7, 3, 5, 13, -1, 17};

        int[] expected = {0, 31, 1, 203, 0, 203};

        assertArrayEquals(expected, solution.solve(A, B, C));
    }

    /**
     * Validates multiple key assignments before and after
     * topology changes.
     *
     * Scenario:
     * - Multiple keys are assigned to INDIA.
     * - RUSSIA is introduced.
     * - Verify ownership changes only for affected keys.
     * - Remove INDIA.
     * - Verify reassignment occurs only for keys owned by INDIA.
     *
     * Concepts Tested:
     * - Consistent hashing reassignment
     * - Incremental ownership updates
     * - Removal semantics
     */
    @Test
    void testBasicExampleTwo() {
        ConsistentHashingRing solution = new ConsistentHashingRing();

        String[] A = {"ADD", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN"};
        String[] B = {"INDIA", "IRYA", "RGJK", "RUSSIA", "BGVH", "SUKJ", "INDIA", "RBRF"};
        int[] C = {11, 31, 7, 3, 5, 13, -1, 17};

        int[] expected = {0, 267, 267, 0, 267, 267, 4, 297};

        assertArrayEquals(expected, solution.solve(A, B, C));
    }

    /**
     * Validates behavior when multiple servers hash
     * to the same ring location.
     *
     * Scenario:
     * - Existing server already occupies location X.
     * - New server hashes to same location X.
     *
     * Expected Behavior:
     * - Existing keys remain assigned to current owners.
     * - No reassignment should occur.
     * - Future ASSIGN operations should use the latest server
     *   added at location X.
     *
     * Concepts Tested:
     * - Collision handling
     * - Sticky ownership invariant
     * - Latest-server-wins rule for future assignments
     */
    @Test
    void testSameLocationAndStickyOwnershipCaseOne() {
        ConsistentHashingRing solution = new ConsistentHashingRing();

        String[] A = {
                "ADD", "ASSIGN", "ASSIGN", "ASSIGN",
                "ADD", "ASSIGN", "ASSIGN", "ASSIGN",
                "ADD", "ASSIGN", "ASSIGN", "ASSIGN",
                "ADD", "ASSIGN", "ASSIGN", "ASSIGN",
                "REMOVE", "ASSIGN", "ASSIGN", "ASSIGN",
                "REMOVE", "ASSIGN", "ASSIGN", "ASSIGN",
                "REMOVE", "ASSIGN", "ASSIGN"
        };

        String[] B = {
                "INDIA", "VLVL", "OXXV", "HHGN",
                "RUSSIA", "AWNF", "SPHI", "FXKT",
                "CHINA", "JXZU", "BWPK", "JYWN",
                "GERMANY", "ZKYK", "HLQZ", "BRMS",
                "INDIA", "FMVA", "NPJO", "GACA",
                "RUSSIA", "ZMWM", "XVUA", "IDUW",
                "CHINA", "EHWW", "KROX"
        };

        int[] C = {
                431, 563, 223, 761,
                197, 409, 31, 223,
                769, 619, 991, 613,
                139, 797, 547, 821,
                -1, 131, 577, 269,
                -1, 499, 599, 29,
                -1, 13, 337
        };

        int[] expected = {
                0, 207, 207, 207,
                3, 207, 207, 207,
                0, 59, 251, 207,
                0, 59, 207, 207,
                6, 251, 59, 251,
                4, 251, 59, 251,
                11, 59, 59
        };

        assertArrayEquals(expected, solution.solve(A, B, C));
    }

    /**
     * Validates removal of servers when multiple servers
     * exist at the same hash location.
     *
     * Scenario:
     * - Multiple servers share a ring location.
     * - Latest server is removed.
     *
     * Expected Behavior:
     * - Future requests fall back to the next available server
     *   at that location.
     * - Only keys owned by removed server are reassigned.
     *
     * Concepts Tested:
     * - Server stack behavior
     * - Ownership preservation
     * - Selective reassignment during removal
     */
    @Test
    void testSameLocationAndStickyOwnershipCaseTwo() {
        ConsistentHashingRing solution = new ConsistentHashingRing();

        String[] A = {
                "ADD", "ASSIGN", "ASSIGN", "ASSIGN",
                "ADD", "ASSIGN", "ASSIGN", "ASSIGN",
                "ADD", "ASSIGN", "ASSIGN", "ASSIGN",
                "ADD", "ASSIGN", "ASSIGN", "ASSIGN",
                "REMOVE", "ASSIGN", "ASSIGN", "ASSIGN",
                "REMOVE", "ASSIGN", "ASSIGN", "ASSIGN",
                "REMOVE", "ASSIGN", "ASSIGN"
        };

        String[] B = {
                "INDIA", "GYQF", "SSAH", "DVTQ",
                "RUSSIA", "ZIVQ", "VBWW", "ACDW",
                "CHINA", "YNXC", "MWUN", "NECZ",
                "GERMANY", "OOHQ", "RSTZ", "WRJJ",
                "INDIA", "YLDR", "XDFH", "SCCV",
                "RUSSIA", "QECH", "WPCA", "ZLVQ",
                "CHINA", "RQPJ", "PFWJ"
        };

        int[] C = {
                947, 613, 821, 701,
                193, 683, 19, 467,
                503, 347, 433, 887,
                971, 587, 509, 283,
                -1, 359, 443, 883,
                -1, 487, 853, 223,
                -1, 13, 739
        };

        int[] expected = {
                0, 51, 51, 51,
                1, 51, 207, 51,
                0, 207, 51, 51,
                0, 51, 51, 163,
                8, 163, 163, 163,
                2, 163, 207, 207,
                3, 163, 163
        };

        assertArrayEquals(expected, solution.solve(A, B, C));
    }
}