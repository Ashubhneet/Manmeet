package com.demo.project.Entities;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;

@Entity
public class CategoryMetadataValues {
    @EmbeddedId
   private CategoryMetadataValuesId categoryMetadataValuesId;
    @ManyToOne
    @MapsId("category")
    private Category category;

    @ManyToOne
    @MapsId("categoryMetadataFields")
    private CategoryMetadataFields categoryMetadataFields;

    private String valuesOfField;


 public List<String> getStrings() {
  return Arrays.asList(valuesOfField.split(","));
 }

 public void setStrings(List<String> list) {
  valuesOfField= String.join(",", list);
 }

}
