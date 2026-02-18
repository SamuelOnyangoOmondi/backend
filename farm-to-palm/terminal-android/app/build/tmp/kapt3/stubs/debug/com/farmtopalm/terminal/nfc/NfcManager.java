package com.farmtopalm.terminal.nfc;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/farmtopalm/terminal/nfc/NfcManager;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "nfcAdapter", "Landroid/nfc/NfcAdapter;", "getNfcAdapter", "()Landroid/nfc/NfcAdapter;", "nfcAdapter$delegate", "Lkotlin/Lazy;", "disableForegroundDispatch", "", "enableForegroundDispatch", "fromIntent", "Landroid/nfc/Tag;", "intent", "Landroid/content/Intent;", "isNfcAvailable", "", "isNfcEnabled", "app_debug"})
public final class NfcManager {
    @org.jetbrains.annotations.NotNull()
    private final android.app.Activity activity = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy nfcAdapter$delegate = null;
    
    public NfcManager(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
        super();
    }
    
    private final android.nfc.NfcAdapter getNfcAdapter() {
        return null;
    }
    
    public final boolean isNfcAvailable() {
        return false;
    }
    
    public final boolean isNfcEnabled() {
        return false;
    }
    
    public final void enableForegroundDispatch() {
    }
    
    public final void disableForegroundDispatch() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.nfc.Tag fromIntent(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
        return null;
    }
}