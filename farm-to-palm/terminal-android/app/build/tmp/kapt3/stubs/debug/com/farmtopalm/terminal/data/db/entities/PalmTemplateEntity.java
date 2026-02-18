package com.farmtopalm.terminal.data.db.entities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0007H\u00c6\u0003J\t\u0010(\u001a\u00020\nH\u00c6\u0003J\t\u0010)\u001a\u00020\fH\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u007f\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00100\u001a\u00020\nH\u0016J\t\u00101\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015\u00a8\u00062"}, d2 = {"Lcom/farmtopalm/terminal/data/db/entities/PalmTemplateEntity;", "", "id", "", "studentId", "hand", "rgbFeatureEnc", "", "irFeatureEnc", "quality", "", "createdAt", "", "streamType", "rgbModelHash", "irModelHash", "sdkTemplateId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B[BIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCreatedAt", "()J", "getHand", "()Ljava/lang/String;", "getId", "getIrFeatureEnc", "()[B", "getIrModelHash", "getQuality", "()I", "getRgbFeatureEnc", "getRgbModelHash", "getSdkTemplateId", "getStreamType", "getStudentId", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
@androidx.room.Entity(tableName = "palm_templates", foreignKeys = {@androidx.room.ForeignKey(entity = com.farmtopalm.terminal.data.db.entities.StudentEntity.class, parentColumns = {"id"}, childColumns = {"studentId"}, onDelete = 5)}, indices = {@androidx.room.Index(value = {"studentId"}), @androidx.room.Index(value = {"sdkTemplateId"})})
public final class PalmTemplateEntity {
    @androidx.room.PrimaryKey()
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String studentId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String hand = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] rgbFeatureEnc = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] irFeatureEnc = null;
    private final int quality = 0;
    private final long createdAt = 0L;
    
    /**
     * Stream type at enrollment (e.g. "RGB_IR", "IR"); null = legacy row.
     */
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String streamType = null;
    
    /**
     * Model hash at enrollment for RGB; null = legacy.
     */
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String rgbModelHash = null;
    
    /**
     * Model hash at enrollment for IR; null = legacy.
     */
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String irModelHash = null;
    
    /**
     * SDK internal template ID from register-mode capture; used for identify-mode match lookup.
     */
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String sdkTemplateId = null;
    
    public PalmTemplateEntity(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String studentId, @org.jetbrains.annotations.NotNull()
    java.lang.String hand, @org.jetbrains.annotations.NotNull()
    byte[] rgbFeatureEnc, @org.jetbrains.annotations.NotNull()
    byte[] irFeatureEnc, int quality, long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String streamType, @org.jetbrains.annotations.Nullable()
    java.lang.String rgbModelHash, @org.jetbrains.annotations.Nullable()
    java.lang.String irModelHash, @org.jetbrains.annotations.Nullable()
    java.lang.String sdkTemplateId) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStudentId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHand() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getRgbFeatureEnc() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getIrFeatureEnc() {
        return null;
    }
    
    public final int getQuality() {
        return 0;
    }
    
    public final long getCreatedAt() {
        return 0L;
    }
    
    /**
     * Stream type at enrollment (e.g. "RGB_IR", "IR"); null = legacy row.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStreamType() {
        return null;
    }
    
    /**
     * Model hash at enrollment for RGB; null = legacy.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRgbModelHash() {
        return null;
    }
    
    /**
     * Model hash at enrollment for IR; null = legacy.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getIrModelHash() {
        return null;
    }
    
    /**
     * SDK internal template ID from register-mode capture; used for identify-mode match lookup.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSdkTemplateId() {
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] component5() {
        return null;
    }
    
    public final int component6() {
        return 0;
    }
    
    public final long component7() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.farmtopalm.terminal.data.db.entities.PalmTemplateEntity copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String studentId, @org.jetbrains.annotations.NotNull()
    java.lang.String hand, @org.jetbrains.annotations.NotNull()
    byte[] rgbFeatureEnc, @org.jetbrains.annotations.NotNull()
    byte[] irFeatureEnc, int quality, long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String streamType, @org.jetbrains.annotations.Nullable()
    java.lang.String rgbModelHash, @org.jetbrains.annotations.Nullable()
    java.lang.String irModelHash, @org.jetbrains.annotations.Nullable()
    java.lang.String sdkTemplateId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}