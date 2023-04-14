// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service3.proto

package com.learn.service3;

public interface WeightLossWeeklyPlanRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:WeightLossWeeklyPlanRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Current weight in kilogram.
   * </pre>
   *
   * <code>double currentWeight = 1;</code>
   */
  double getCurrentWeight();

  /**
   * <pre>
   * Weight goal in kilogram.
   * </pre>
   *
   * <code>double weightGoal = 2;</code>
   */
  double getWeightGoal();

  /**
   * <pre>
   * Number of weeks for the plan.
   * </pre>
   *
   * <code>int32 numberOfWeeks = 3;</code>
   */
  int getNumberOfWeeks();
}
