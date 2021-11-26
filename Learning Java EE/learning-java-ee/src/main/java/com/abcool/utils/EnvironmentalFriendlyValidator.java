package com.abcool.utils;

import com.abcool.entity.EngineType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnvironmentalFriendlyValidator implements ConstraintValidator<EnvironmentalFriendly, EngineType> {
   public void initialize(EnvironmentalFriendly constraint) {
   }

   public boolean isValid(EngineType engineType, ConstraintValidatorContext context) {
      return engineType == EngineType.ELECTRIC;
   }
}
