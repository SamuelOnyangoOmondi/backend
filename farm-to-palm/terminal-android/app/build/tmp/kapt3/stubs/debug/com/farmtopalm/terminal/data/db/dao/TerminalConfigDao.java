package com.farmtopalm.terminal.data.db.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/farmtopalm/terminal/data/db/dao/TerminalConfigDao;", "", "get", "Lcom/farmtopalm/terminal/data/db/entities/TerminalConfigEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "", "entity", "(Lcom/farmtopalm/terminal/data/db/entities/TerminalConfigEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateHeartbeat", "at", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface TerminalConfigDao {
    
    @androidx.room.Query(value = "SELECT * FROM terminal_config WHERE id = 1 LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object get(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.farmtopalm.terminal.data.db.entities.TerminalConfigEntity> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.farmtopalm.terminal.data.db.entities.TerminalConfigEntity entity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE terminal_config SET lastHeartbeatAt = :at WHERE id = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateHeartbeat(long at, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}