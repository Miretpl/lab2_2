package edu.iis.mto.similarity;

import edu.iis.mto.search.SequenceSearcherMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimilarityFinderStateTest {

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

    }
}
