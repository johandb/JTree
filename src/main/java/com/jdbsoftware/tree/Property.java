package com.jdbsoftware.tree;

/**
 * Class to hold the property.
 * 
 * @author Johan
 *
 */
public class Property {

    private String key;
    private String value;

    /**
     * Constructs a Property
     */
    public Property() {
    }

    /**
     * Constructs a Property
     *
     * @param key
     */
    public Property(String key) {
        this.key = key;
    }

    /**
     * Constructs a Property
     *
     * @param key
     * @param value
     */
    public Property(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Property other = (Property) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return key;
    }

}
