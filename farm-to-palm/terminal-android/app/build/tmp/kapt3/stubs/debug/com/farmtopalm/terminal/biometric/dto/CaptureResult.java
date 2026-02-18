package com.farmtopalm.terminal.biometric.dto;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0002\u0010\u000eJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014Jl\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u00c6\u0001\u00a2\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010)\u001a\u00020\u0006H\u0016J\t\u0010*\u001a\u00020\bH\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012\u00a8\u0006+"}, d2 = {"Lcom/farmtopalm/terminal/biometric/dto/CaptureResult;", "", "rgbFeature", "", "irFeature", "quality", "", "streamType", "", "rgbModelHash", "irModelHash", "matchTemplateId", "matchScore", "", "([B[BILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;)V", "getIrFeature", "()[B", "getIrModelHash", "()Ljava/lang/String;", "getMatchScore", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getMatchTemplateId", "getQuality", "()I", "getRgbFeature", "getRgbModelHash", "getStreamType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "([B[BILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;)Lcom/farmtopalm/terminal/biometric/dto/CaptureResult;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class CaptureResult {
    @org.jetbrains.annotations.Nullable()
    private final byte[] rgbFeature = null;
    @org.jetbrains.annotations.Nullable()
    private final byte[] irFeature = null;
    private final int quality = 0;
    
    /**
     * Stream type at capture (e.g. "RGB_IR", "IR") for template metadata.
     */
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String streamType = null;
    
    /**
     * Model hash/key for RGB features (device/model version binding).
     */
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String rgbModelHash = null;
    
    /**
     * Model hash/key for IR features (device/model version binding).
     */
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String irModelHash = null;
    
    /**
     * When capture was in identify mode: SDK-reported matched template ID/index (use for DB lookup).
     */
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String matchTemplateId = null;
    
    /**
     * When capture was in identify mode: SDK-reported match score.
     */
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Float matchScore = null;
    
    public CaptureResult(@org.jetbrains.annotations.Nullable()
    byte[] rgbFeature, @org.jetbrains.annotations.Nullable()
    byte[] irFeature, int quality, @org.jetbrains.annotations.Nullable()
    java.lang.String streamType, @org.jetbrains.annotations.Nullable()
    java.lang.String rgbModelHash, @org.jetbrains.annotations.Nullable()
    java.lang.String irModelHash, @org.jetbrains.annotations.Nullable()
    java.lang.String matchTemplateId, @org.jetbrains.annotations.Nullable()
    java.lang.Float matchScore) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final byte[] getRgbFeature() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final byte[] getIrFeature() {
        return null;
    }
    
    public final int getQuality() {
        return 0;
    }
    
    /**
     * Stream type at capture (e.g. "RGB_IR", "IR") for template metadata.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStreamType() {
        return null;
    }
    
    /**
     * Model hash/key for RGB features (device/model version binding).
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRgbModelHash() {
        return null;
    }
    
    /**
     * Model hash/key for IR features (device/model version binding).
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getIrModelHash() {
        return null;
    }
    
    /**
     * When capture was in identify mode: SDK-reported matched template ID/index (use for DB lookup).
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMatchTemplateId() {
        return null;
    }
    
    /**
     * When capture was in identify mode: SDK-reported match score.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float getMatchScore() {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final byte[] component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final byte[] component2() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.farmtopalm.terminal.biometric.dto.CaptureResult copy(@org.jetbrains.annotations.Nullable()
    byte[] rgbFeature, @org.jetbrains.annotations.Nullable()
    byte[] irFeature, int quality, @org.jetbrains.annotations.Nullable()
    java.lang.String streamType, @org.jetbrains.annotations.Nullable()
    java.lang.String rgbModelHash, @org.jetbrains.annotations.Nullable()
    java.lang.String irModelHash, @org.jetbrains.annotations.Nullable()
    java.lang.String matchTemplateId, @org.jetbrains.annotations.Nullable()
    java.lang.Float matchScore) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}