package com.farmtopalm.terminal.sync;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\u00020\u000eH\u0096@\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/farmtopalm/terminal/sync/SyncWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "params", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "db", "Lcom/farmtopalm/terminal/data/db/AppDatabase;", "eventRepo", "Lcom/farmtopalm/terminal/data/repo/EventRepo;", "terminalRepo", "Lcom/farmtopalm/terminal/data/repo/TerminalRepo;", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class SyncWorker extends androidx.work.CoroutineWorker {
    @org.jetbrains.annotations.NotNull()
    private final com.farmtopalm.terminal.data.db.AppDatabase db = null;
    @org.jetbrains.annotations.NotNull()
    private final com.farmtopalm.terminal.data.repo.TerminalRepo terminalRepo = null;
    @org.jetbrains.annotations.NotNull()
    private final com.farmtopalm.terminal.data.repo.EventRepo eventRepo = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String WORK_NAME = "FarmToPalmSync";
    private static final int BACKOFF_DELAY = 5;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.concurrent.TimeUnit BACKOFF_UNIT = java.util.concurrent.TimeUnit.MINUTES;
    @org.jetbrains.annotations.NotNull()
    public static final com.farmtopalm.terminal.sync.SyncWorker.Companion Companion = null;
    
    public SyncWorker(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    androidx.work.WorkerParameters params) {
        super(null, null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object doWork(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/farmtopalm/terminal/sync/SyncWorker$Companion;", "", "()V", "BACKOFF_DELAY", "", "getBACKOFF_DELAY", "()I", "BACKOFF_UNIT", "Ljava/util/concurrent/TimeUnit;", "getBACKOFF_UNIT", "()Ljava/util/concurrent/TimeUnit;", "WORK_NAME", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final int getBACKOFF_DELAY() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.concurrent.TimeUnit getBACKOFF_UNIT() {
            return null;
        }
    }
}