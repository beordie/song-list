package com.beordie.common.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author yishun
 * @version 1.0
 * @date 2023/2/3 11:12
 * @describe
 */
@Data
public class SongCommend<T, K> {
    /**
     * commend song ids
     */
    private Set<T> songIds;
    /**
     * key of cache
     */
    private K key;

    public void setSongIds(T [] ids) {
        for (T id : ids) {
            songIds.add(id);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongCommend<?, ?> that = (SongCommend<?, ?>) o;
        return key.equals(that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    public SongCommend() {
        this.songIds = new HashSet<T>();
    }
}
