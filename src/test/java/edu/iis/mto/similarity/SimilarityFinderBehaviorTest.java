package edu.iis.mto.similarity;

import edu.iis.mto.search.SequenceSearcherMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SimilarityFinderBehaviorTest {

    private SimilarityFinder similarityFinder = null;
    private SequenceSearcherMock sequenceSearcherMock = null;

    @BeforeEach void init() {
        sequenceSearcherMock = new SequenceSearcherMock();
        similarityFinder = new SimilarityFinder(sequenceSearcherMock);
    }

    @Test public void checkBehaviorWhenBothSeqAreEmpty () {
        int[] seq1 = new int[]{}, seq2 = new int[]{};

        assertDoesNotThrow(() -> similarityFinder.calculateJackardSimilarity(seq1, seq2));
    }

    @Test public void checkBehaviorWhenFirstSeqIsEmpty () {
        int[] seq1 = new int[]{}, seq2 = new int[]{1, 2, 3};

        assertDoesNotThrow(() -> similarityFinder.calculateJackardSimilarity(seq1, seq2));
    }

    @Test public void checkBehaviorSecondSeqIsEmpty () {
        int[] seq1 = new int[]{1, 2, 3}, seq2 = new int[]{};

        assertDoesNotThrow(() -> similarityFinder.calculateJackardSimilarity(seq1, seq2));
    }

    @Test public void checkBehaviorBothSeqAreFilled () {
        int[] seq1 = new int[]{1, 2, 3}, seq2 = new int[]{1, 2, 3};

        assertDoesNotThrow(() -> similarityFinder.calculateJackardSimilarity(seq1, seq2));
    }

    @Test public void checkBehaviorBothSeqAreNull () {
        int[] seq1 = null, seq2 = null;

        assertThrows(NullPointerException.class, () -> similarityFinder.calculateJackardSimilarity(seq1, seq2));
    }

    @Test public void checkBehaviorFirstSeqIsNull () {
        int[] seq1 = null, seq2 = new int[]{1, 2, 3};

        assertThrows(NullPointerException.class, () -> similarityFinder.calculateJackardSimilarity(seq1, seq2));
    }

    @Test public void checkBehaviorSecondSeqIsNull () {
        int[] seq1 = new int[]{1, 2, 3}, seq2 = null;

        assertThrows(IllegalArgumentException.class, () -> similarityFinder.calculateJackardSimilarity(seq1, seq2));
    }

    @Test public void checkBehaviorWhenSequenceSeacherIsNull () {

    }
}
