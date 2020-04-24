package edu.iis.mto.similarity;

import edu.iis.mto.search.SequenceSearcherMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SimilarityFinderTest {

    private SimilarityFinder similarityFinder = null;
    private SequenceSearcherMock sequenceSearcherMock = null;

    @BeforeEach void init() {
        sequenceSearcherMock = new SequenceSearcherMock();
        similarityFinder = new SimilarityFinder(sequenceSearcherMock);
    }

    @Test public void checkStateWhenBothSeqAreEmpty () {
        int[] seq1 = new int[]{}, seq2 = new int[]{};

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        assertEquals(result, 1.0);
    }

    @Test public void checkStateWhenFirstSeqIsEmpty () {
        int[] seq1 = new int[]{}, seq2 = new int[]{1, 2, 3};

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        assertEquals(result, 0.0);
    }

    @Test public void checkStateSecondSeqIsEmpty () {
        int[] seq1 = new int[]{1, 2, 3}, seq2 = new int[]{};

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        assertEquals(result, 0.0);
    }

    @Test public void checkStateFullMatch () {
        int[] seq1 = new int[]{1, 2, 3}, seq2 = new int[]{1, 2, 3};

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        assertEquals(result, 1.0);
    }

    @Test public void checkStateNoMatch () {
        int[] seq1 = new int[]{1, 2, 3}, seq2 = new int[]{4, 5, 6};

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        assertEquals(result, 0.0);
    }

    @Test public void checkStateHalfMatch () {
        int[] seq1 = new int[]{1, 2}, seq2 = new int[]{1, 2, 3, 4};

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        assertEquals(result, 0.5);
    }

    @Test public void checkStateSixtyPerMatch () {
        int[] seq1 = new int[]{1, 2, 3, 4}, seq2 = new int[]{1, 2, 3, 5};

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        assertEquals(result, 0.6);
    }

    @Test public void checkStateSeventyFivePerMatch () {
        int[] seq1 = new int[]{1, 2, 3, 4}, seq2 = new int[]{1, 2, 3};

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        assertEquals(result, 0.75);
    }

    @Test public void checkStateTwentyFivePerMatch () {
        int[] seq1 = new int[]{1}, seq2 = new int[]{1, 2, 3, 4};

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        assertEquals(result, 0.25);
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
        SimilarityFinder nullSimilarityFinder = new SimilarityFinder(null);
        int[] seq1 = new int[]{1, 2, 3}, seq2 = new int[]{1, 2, 3};

        assertThrows(NullPointerException.class, () -> nullSimilarityFinder.calculateJackardSimilarity(seq1, seq2));
    }
}
