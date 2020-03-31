package edu.iis.mto.search;

public class SequenceSearcherMock implements SequenceSearcher {

    public int searchResultCalls = 0;

    @Override public SearchResult search(int elem, int[] seq) {
        searchResultCalls++;

        if (seq == null) {
            throw new IllegalArgumentException();
        }

        SearchResult.Builder builder = SearchResult.builder();

        for (int i = 0; i < seq.length; i++) {
            if (elem == seq[i]) {
                builder.withFound(true);
                builder.withPosition(i);
                break;
            }
        }

        return builder.build();
    }
}
