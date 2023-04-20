package com.demo.project.Entities;

import jakarta.persistence.*;

@Entity
public class CategoryMetadataValues {
    @EmbeddedId
   private CategoryMetadataValuesId categoryMetadataValuesId=new CategoryMetadataValuesId();
    @ManyToOne
    @MapsId("CategoryId")
    private Category category;

    @ManyToOne
    @MapsId("CategoryMetadataId")
    private CategoryMetadataFields categoryMetadataFields;

}
