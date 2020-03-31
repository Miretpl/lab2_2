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

    }

    @Test public void checkStateSecondSeqIsEmpty () {

    }

    @Test public void checkStateWhenFirstSeqIsFilled () {

    }

    @Test public void checkStateSecondSeqIsFilled () {

    }

    @Test public void checkStateBothSeqAreFilled () {

    }

    @Test public void checkStateFullMatch () {

    }

    @Test public void checkStateNoMatch () {

    }
}
