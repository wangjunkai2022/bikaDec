.class Landroid/support/v4/app/ActionBarDrawerToggle$ActionBarDrawerToggleImplIcs;
.super Ljava/lang/Object;
.source "ActionBarDrawerToggle.java"

# interfaces
.implements Landroid/support/v4/app/ActionBarDrawerToggle$ActionBarDrawerToggleImpl;


# annotations
.annotation build Landroid/support/annotation/RequiresApi;
    value = 0xb
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v4/app/ActionBarDrawerToggle;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ActionBarDrawerToggleImplIcs"
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .line 115
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getThemeUpIndicator(Landroid/app/Activity;)Landroid/graphics/drawable/Drawable;
    .locals 0

    .line 120
    invoke-static {p1}, Landroid/support/v4/app/ActionBarDrawerToggleIcs;->getThemeUpIndicator(Landroid/app/Activity;)Landroid/graphics/drawable/Drawable;

    move-result-object p1

    return-object p1
.end method

.method public setActionBarDescription(Ljava/lang/Object;Landroid/app/Activity;I)Ljava/lang/Object;
    .locals 0

    .line 132
    invoke-static {p1, p2, p3}, Landroid/support/v4/app/ActionBarDrawerToggleIcs;->setActionBarDescription(Ljava/lang/Object;Landroid/app/Activity;I)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public setActionBarUpIndicator(Ljava/lang/Object;Landroid/app/Activity;Landroid/graphics/drawable/Drawable;I)Ljava/lang/Object;
    .locals 0

    .line 126
    invoke-static {p1, p2, p3, p4}, Landroid/support/v4/app/ActionBarDrawerToggleIcs;->setActionBarUpIndicator(Ljava/lang/Object;Landroid/app/Activity;Landroid/graphics/drawable/Drawable;I)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method
