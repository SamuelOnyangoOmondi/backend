package com.farmtopalm.terminal.data.db.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u00a7@\u00a2\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\u00112\u0006\u0010\b\u001a\u00020\tH\'J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0014"}, d2 = {"Lcom/farmtopalm/terminal/data/db/dao/PalmTemplateDao;", "", "delete", "", "entity", "Lcom/farmtopalm/terminal/data/db/entities/PalmTemplateEntity;", "(Lcom/farmtopalm/terminal/data/db/entities/PalmTemplateEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteByStudent", "studentId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllSync", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBySdkTemplateId", "sdkTemplateId", "getByStudent", "Lkotlinx/coroutines/flow/Flow;", "getByStudentSync", "insert", "app_debug"})
@androidx.room.Dao()
public abstract interface PalmTemplateDao {
    
    @androidx.room.Query(value = "SELECT * FROM palm_templates WHERE studentId = :studentId")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.farmtopalm.terminal.data.db.entities.PalmTemplateEntity>> getByStudent(@org.jetbrains.annotations.NotNull()
    java.lang.String studentId);
    
    @androidx.room.Query(value = "SELECT * FROM palm_templates WHERE studentId = :studentId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getByStudentSync(@org.jetbrains.annotations.NotNull()
    java.lang.String studentId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.farmtopalm.terminal.data.db.entities.PalmTemplateEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM palm_templates WHERE sdkTemplateId = :sdkTemplateId LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBySdkTemplateId(@org.jetbrains.annotations.NotNull()
    java.lang.String sdkTemplateId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.farmtopalm.terminal.data.db.entities.PalmTemplateEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM palm_templates")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllSync(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.farmtopalm.terminal.data.db.entities.PalmTemplateEntity>> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.farmtopalm.terminal.data.db.entities.PalmTemplateEntity entity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.farmtopalm.terminal.data.db.entities.PalmTemplateEntity entity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM palm_templates WHERE studentId = :studentId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteByStudent(@org.jetbrains.annotations.NotNull()
    java.lang.String studentId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}