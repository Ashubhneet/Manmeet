package com.demo.project.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CategoryMetadataValuesId implements Serializable {
    private Long category;
    private Long categoryMetadataFields;

    CategoryMetadataValuesId(){}

    public CategoryMetadataValuesId(Long category, Long categoryMetadataFields) {
        this.category = category;
        this.categoryMetadataFields = categoryMetadataFields;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategoryId(Long category) {
        this.category = category;
    }

    public Long getCategoryMetadataFieldId() {
        return categoryMetadataFields;
    }

    public void setCategoryMetadataFieldId(Long categoryMetadataFieldId) {
        this.categoryMetadataFields = categoryMetadataFieldId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryMetadataValuesId that = (CategoryMetadataValuesId) o;
        return Objects.equals(category, that.category) && Objects.equals(categoryMetadataFields, that.categoryMetadataFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, categoryMetadataFields);
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public Long getCategoryMetadataFields() {
        return categoryMetadataFields;
    }

    public void setCategoryMetadataFields(Long categoryMetadataFields) {
        this.categoryMetadataFields = categoryMetadataFields;
    }
}

