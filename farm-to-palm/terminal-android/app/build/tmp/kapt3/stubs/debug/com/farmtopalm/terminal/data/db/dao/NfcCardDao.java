package com.farmtopalm.terminal.data.db.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\t\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/farmtopalm/terminal/data/db/dao/NfcCardDao;", "", "delete", "", "entity", "Lcom/farmtopalm/terminal/data/db/entities/NfcCardEntity;", "(Lcom/farmtopalm/terminal/data/db/entities/NfcCardEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getByStudent", "", "studentId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getByUid", "uid", "insert", "app_debug"})
@androidx.room.Dao()
public abstract interface NfcCardDao {
    
    @androidx.room.Query(value = "SELECT * FROM nfc_cards WHERE uid = :uid LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getByUid(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.farmtopalm.terminal.data.db.entities.NfcCardEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM nfc_cards WHERE studentId = :studentId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getByStudent(@org.jetbrains.annotations.NotNull()
    java.lang.String studentId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.farmtopalm.terminal.data.db.entities.NfcCardEntity>> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.farmtopalm.terminal.data.db.entities.NfcCardEntity entity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.farmtopalm.terminal.data.db.entities.NfcCardEntity entity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}