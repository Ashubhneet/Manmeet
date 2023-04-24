package com.demo.project.entities;

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

 public CategoryMetadataValuesId getCategoryMetadataValuesId() {
  return categoryMetadataValuesId;
 }

 public void setCategoryMetadataValuesId(CategoryMetadataValuesId categoryMetadataValuesId) {
  this.categoryMetadataValuesId = categoryMetadataValuesId;
 }

 public Category getCategory() {
  return category;
 }

 public void setCategory(Category category) {
  this.category = category;
 }

 public CategoryMetadataFields getCategoryMetadataFields() {
  return categoryMetadataFields;
 }

 public void setCategoryMetadataFields(CategoryMetadataFields categoryMetadataFields) {
  this.categoryMetadataFields = categoryMetadataFields;
 }

 public String getValuesOfField() {
  return valuesOfField;
 }

 public void setValuesOfField(String valuesOfField) {
  this.valuesOfField = valuesOfField;
 }

}
