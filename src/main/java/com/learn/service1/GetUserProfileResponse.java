// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service1.proto

package com.learn.service1;

/**
 * Protobuf type {@code GetUserProfileResponse}
 */
public  final class GetUserProfileResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:GetUserProfileResponse)
    GetUserProfileResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetUserProfileResponse.newBuilder() to construct.
  private GetUserProfileResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetUserProfileResponse() {
    name_ = "";
    height_ = 0D;
    weight_ = 0D;
    stepCountGoal_ = 0;
    weightGoal_ = 0D;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GetUserProfileResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            name_ = s;
            break;
          }
          case 17: {

            height_ = input.readDouble();
            break;
          }
          case 25: {

            weight_ = input.readDouble();
            break;
          }
          case 32: {

            stepCountGoal_ = input.readInt32();
            break;
          }
          case 41: {

            weightGoal_ = input.readDouble();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.learn.service1.Service1Impl.internal_static_GetUserProfileResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.learn.service1.Service1Impl.internal_static_GetUserProfileResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.learn.service1.GetUserProfileResponse.class, com.learn.service1.GetUserProfileResponse.Builder.class);
  }

  public static final int NAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object name_;
  /**
   * <pre>
   * User's name.
   * </pre>
   *
   * <code>string name = 1;</code>
   */
  public java.lang.String getName() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      name_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * User's name.
   * </pre>
   *
   * <code>string name = 1;</code>
   */
  public com.google.protobuf.ByteString
      getNameBytes() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int HEIGHT_FIELD_NUMBER = 2;
  private double height_;
  /**
   * <pre>
   * User's height in centimetre.
   * </pre>
   *
   * <code>double height = 2;</code>
   */
  public double getHeight() {
    return height_;
  }

  public static final int WEIGHT_FIELD_NUMBER = 3;
  private double weight_;
  /**
   * <pre>
   * User's weight in kilogram.
   * </pre>
   *
   * <code>double weight = 3;</code>
   */
  public double getWeight() {
    return weight_;
  }

  public static final int STEPCOUNTGOAL_FIELD_NUMBER = 4;
  private int stepCountGoal_;
  /**
   * <pre>
   * User's daily step count goal.
   * </pre>
   *
   * <code>int32 stepCountGoal = 4;</code>
   */
  public int getStepCountGoal() {
    return stepCountGoal_;
  }

  public static final int WEIGHTGOAL_FIELD_NUMBER = 5;
  private double weightGoal_;
  /**
   * <pre>
   * User's weight goal in kilogram.
   * </pre>
   *
   * <code>double weightGoal = 5;</code>
   */
  public double getWeightGoal() {
    return weightGoal_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, name_);
    }
    if (height_ != 0D) {
      output.writeDouble(2, height_);
    }
    if (weight_ != 0D) {
      output.writeDouble(3, weight_);
    }
    if (stepCountGoal_ != 0) {
      output.writeInt32(4, stepCountGoal_);
    }
    if (weightGoal_ != 0D) {
      output.writeDouble(5, weightGoal_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, name_);
    }
    if (height_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(2, height_);
    }
    if (weight_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(3, weight_);
    }
    if (stepCountGoal_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, stepCountGoal_);
    }
    if (weightGoal_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(5, weightGoal_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.learn.service1.GetUserProfileResponse)) {
      return super.equals(obj);
    }
    com.learn.service1.GetUserProfileResponse other = (com.learn.service1.GetUserProfileResponse) obj;

    boolean result = true;
    result = result && getName()
        .equals(other.getName());
    result = result && (
        java.lang.Double.doubleToLongBits(getHeight())
        == java.lang.Double.doubleToLongBits(
            other.getHeight()));
    result = result && (
        java.lang.Double.doubleToLongBits(getWeight())
        == java.lang.Double.doubleToLongBits(
            other.getWeight()));
    result = result && (getStepCountGoal()
        == other.getStepCountGoal());
    result = result && (
        java.lang.Double.doubleToLongBits(getWeightGoal())
        == java.lang.Double.doubleToLongBits(
            other.getWeightGoal()));
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + NAME_FIELD_NUMBER;
    hash = (53 * hash) + getName().hashCode();
    hash = (37 * hash) + HEIGHT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getHeight()));
    hash = (37 * hash) + WEIGHT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getWeight()));
    hash = (37 * hash) + STEPCOUNTGOAL_FIELD_NUMBER;
    hash = (53 * hash) + getStepCountGoal();
    hash = (37 * hash) + WEIGHTGOAL_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getWeightGoal()));
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.learn.service1.GetUserProfileResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.learn.service1.GetUserProfileResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.learn.service1.GetUserProfileResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.learn.service1.GetUserProfileResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.learn.service1.GetUserProfileResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.learn.service1.GetUserProfileResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.learn.service1.GetUserProfileResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.learn.service1.GetUserProfileResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.learn.service1.GetUserProfileResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.learn.service1.GetUserProfileResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.learn.service1.GetUserProfileResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.learn.service1.GetUserProfileResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.learn.service1.GetUserProfileResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code GetUserProfileResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:GetUserProfileResponse)
      com.learn.service1.GetUserProfileResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.learn.service1.Service1Impl.internal_static_GetUserProfileResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.learn.service1.Service1Impl.internal_static_GetUserProfileResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.learn.service1.GetUserProfileResponse.class, com.learn.service1.GetUserProfileResponse.Builder.class);
    }

    // Construct using com.learn.service1.GetUserProfileResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      name_ = "";

      height_ = 0D;

      weight_ = 0D;

      stepCountGoal_ = 0;

      weightGoal_ = 0D;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.learn.service1.Service1Impl.internal_static_GetUserProfileResponse_descriptor;
    }

    @java.lang.Override
    public com.learn.service1.GetUserProfileResponse getDefaultInstanceForType() {
      return com.learn.service1.GetUserProfileResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.learn.service1.GetUserProfileResponse build() {
      com.learn.service1.GetUserProfileResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.learn.service1.GetUserProfileResponse buildPartial() {
      com.learn.service1.GetUserProfileResponse result = new com.learn.service1.GetUserProfileResponse(this);
      result.name_ = name_;
      result.height_ = height_;
      result.weight_ = weight_;
      result.stepCountGoal_ = stepCountGoal_;
      result.weightGoal_ = weightGoal_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.learn.service1.GetUserProfileResponse) {
        return mergeFrom((com.learn.service1.GetUserProfileResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.learn.service1.GetUserProfileResponse other) {
      if (other == com.learn.service1.GetUserProfileResponse.getDefaultInstance()) return this;
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        onChanged();
      }
      if (other.getHeight() != 0D) {
        setHeight(other.getHeight());
      }
      if (other.getWeight() != 0D) {
        setWeight(other.getWeight());
      }
      if (other.getStepCountGoal() != 0) {
        setStepCountGoal(other.getStepCountGoal());
      }
      if (other.getWeightGoal() != 0D) {
        setWeightGoal(other.getWeightGoal());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.learn.service1.GetUserProfileResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.learn.service1.GetUserProfileResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object name_ = "";
    /**
     * <pre>
     * User's name.
     * </pre>
     *
     * <code>string name = 1;</code>
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        name_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * User's name.
     * </pre>
     *
     * <code>string name = 1;</code>
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * User's name.
     * </pre>
     *
     * <code>string name = 1;</code>
     */
    public Builder setName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      name_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * User's name.
     * </pre>
     *
     * <code>string name = 1;</code>
     */
    public Builder clearName() {
      
      name_ = getDefaultInstance().getName();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * User's name.
     * </pre>
     *
     * <code>string name = 1;</code>
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      name_ = value;
      onChanged();
      return this;
    }

    private double height_ ;
    /**
     * <pre>
     * User's height in centimetre.
     * </pre>
     *
     * <code>double height = 2;</code>
     */
    public double getHeight() {
      return height_;
    }
    /**
     * <pre>
     * User's height in centimetre.
     * </pre>
     *
     * <code>double height = 2;</code>
     */
    public Builder setHeight(double value) {
      
      height_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * User's height in centimetre.
     * </pre>
     *
     * <code>double height = 2;</code>
     */
    public Builder clearHeight() {
      
      height_ = 0D;
      onChanged();
      return this;
    }

    private double weight_ ;
    /**
     * <pre>
     * User's weight in kilogram.
     * </pre>
     *
     * <code>double weight = 3;</code>
     */
    public double getWeight() {
      return weight_;
    }
    /**
     * <pre>
     * User's weight in kilogram.
     * </pre>
     *
     * <code>double weight = 3;</code>
     */
    public Builder setWeight(double value) {
      
      weight_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * User's weight in kilogram.
     * </pre>
     *
     * <code>double weight = 3;</code>
     */
    public Builder clearWeight() {
      
      weight_ = 0D;
      onChanged();
      return this;
    }

    private int stepCountGoal_ ;
    /**
     * <pre>
     * User's daily step count goal.
     * </pre>
     *
     * <code>int32 stepCountGoal = 4;</code>
     */
    public int getStepCountGoal() {
      return stepCountGoal_;
    }
    /**
     * <pre>
     * User's daily step count goal.
     * </pre>
     *
     * <code>int32 stepCountGoal = 4;</code>
     */
    public Builder setStepCountGoal(int value) {
      
      stepCountGoal_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * User's daily step count goal.
     * </pre>
     *
     * <code>int32 stepCountGoal = 4;</code>
     */
    public Builder clearStepCountGoal() {
      
      stepCountGoal_ = 0;
      onChanged();
      return this;
    }

    private double weightGoal_ ;
    /**
     * <pre>
     * User's weight goal in kilogram.
     * </pre>
     *
     * <code>double weightGoal = 5;</code>
     */
    public double getWeightGoal() {
      return weightGoal_;
    }
    /**
     * <pre>
     * User's weight goal in kilogram.
     * </pre>
     *
     * <code>double weightGoal = 5;</code>
     */
    public Builder setWeightGoal(double value) {
      
      weightGoal_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * User's weight goal in kilogram.
     * </pre>
     *
     * <code>double weightGoal = 5;</code>
     */
    public Builder clearWeightGoal() {
      
      weightGoal_ = 0D;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:GetUserProfileResponse)
  }

  // @@protoc_insertion_point(class_scope:GetUserProfileResponse)
  private static final com.learn.service1.GetUserProfileResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.learn.service1.GetUserProfileResponse();
  }

  public static com.learn.service1.GetUserProfileResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetUserProfileResponse>
      PARSER = new com.google.protobuf.AbstractParser<GetUserProfileResponse>() {
    @java.lang.Override
    public GetUserProfileResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GetUserProfileResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetUserProfileResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetUserProfileResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.learn.service1.GetUserProfileResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

