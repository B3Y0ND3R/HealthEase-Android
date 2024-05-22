package com.example.healthease.LabTest;
/**
 * The {@code TestOccurrence} class represents an occurrence of a laboratory test.
 * It contains information about the specific test (LabTest) and the branch where it occurred.
 */
public class TestOccurrence {
    /** The laboratory test associated with this occurrence. */

    private LabTest labTest;
    /** The branch where the test occurred. */

    private String branch;
    /**
     * Constructs a new {@code TestOccurrence} with the specified laboratory test and branch.
     *
     * @param labTest the laboratory test associated with this occurrence
     * @param branch  the branch where the test occurred
     */
    public TestOccurrence(LabTest labTest, String branch) {
        this.labTest = labTest;
        this.branch = branch;
    }
    /**
     * Returns the laboratory test associated with this occurrence.
     *
     * @return the laboratory test
     */
    public LabTest getLabTest() {
        return labTest;
    }
    /**
     * Returns the branch where the test occurred.
     *
     * @return the branch where the test occurred
     */
    public String getBranch() {
        return branch;
    }
}
