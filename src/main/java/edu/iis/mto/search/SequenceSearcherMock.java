package edu.iis.mto.search;

import java.util.HashMap;
import java.util.Map;

public class SequenceSearcherMock implements SequenceSearcher {

    private Map<Integer, Integer> positionMap = new HashMap<>();

    public void setPositionMap(int[] table) {
        positionMap.clear();

        if (table != null) {
            for (int i = 0; i < table.length; i++) {
                positionMap.put(table[i], i);
            }
        }
    }

    @Override public SearchResult search(int elem, int[] seq) {
        if (seq == null) {
            throw new IllegalArgumentException();
        }

        SearchResult.Builder builder = SearchResult.builder();
        builder.withFound(false);

        int position = -1;

        if (positionMap.containsKey(elem)) {
            position = positionMap.get(elem);
        }

        if (position > -1) {
            builder.withFound(true);
            builder.withPosition(position);
        }

        return builder.build();
    }
}
