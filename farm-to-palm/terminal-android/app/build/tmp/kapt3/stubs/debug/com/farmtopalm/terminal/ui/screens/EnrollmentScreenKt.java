package com.farmtopalm.terminal.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u001a\u00d4\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\'\u0010\u0006\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00010\u00072\u0082\u0002\u0010\f\u001a\u00fd\u0001\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0019\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007\u001a.\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u000e2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\u001f\u001a\u00020 H\u0007\u00a8\u0006!"}, d2 = {"EnrollmentScreen", "", "palmManager", "Lcom/farmtopalm/terminal/biometric/PalmBiometricManager;", "adminPinVerified", "", "onRequestPin", "Lkotlin/Function1;", "Lkotlin/Function0;", "Lkotlin/ParameterName;", "name", "onVerified", "onSaveTemplate", "Lkotlin/Function11;", "", "externalId", "hand", "", "rgb", "ir", "", "quality", "streamType", "rgbModelHash", "irModelHash", "sdkTemplateId", "onSaved", "onBack", "HandDropdown", "value", "onChange", "modifier", "Landroidx/compose/ui/Modifier;", "app_debug"})
public final class EnrollmentScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void EnrollmentScreen(@org.jetbrains.annotations.NotNull()
    com.farmtopalm.terminal.biometric.PalmBiometricManager palmManager, boolean adminPinVerified, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super kotlin.jvm.functions.Function0<kotlin.Unit>, kotlin.Unit> onRequestPin, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function11<? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super byte[], ? super byte[], ? super java.lang.Integer, ? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super kotlin.jvm.functions.Function0<kotlin.Unit>, kotlin.Unit> onSaveTemplate, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void HandDropdown(@org.jetbrains.annotations.NotNull()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onChange, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
}