.class public Lcom/picacomic/fregata/activities/SplashActivity_ViewBinding;
.super Ljava/lang/Object;
.source "SplashActivity_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private iZ:Lcom/picacomic/fregata/activities/SplashActivity;


# direct methods
.method public constructor <init>(Lcom/picacomic/fregata/activities/SplashActivity;Landroid/view/View;)V
    .locals 3
    .annotation build Landroid/support/annotation/UiThread;
    .end annotation

    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    iput-object p1, p0, Lcom/picacomic/fregata/activities/SplashActivity_ViewBinding;->iZ:Lcom/picacomic/fregata/activities/SplashActivity;

    const-string v0, "field \'linearLayout_options\'"

    .line 27
    const-class v1, Landroid/widget/LinearLayout;

    const v2, 0x7f0901bc

    invoke-static {p2, v2, v0, v1}, Lbutterknife/internal/Utils;->findRequiredViewAsType(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p1, Lcom/picacomic/fregata/activities/SplashActivity;->linearLayout_options:Landroid/widget/LinearLayout;

    const-string v0, "field \'linearLayout_error\'"

    .line 28
    const-class v1, Landroid/widget/LinearLayout;

    const v2, 0x7f0901bb

    invoke-static {p2, v2, v0, v1}, Lbutterknife/internal/Utils;->findRequiredViewAsType(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p1, Lcom/picacomic/fregata/activities/SplashActivity;->linearLayout_error:Landroid/widget/LinearLayout;

    const-string v0, "field \'button_server1\'"

    .line 29
    const-class v1, Landroid/widget/Button;

    const v2, 0x7f09008b

    invoke-static {p2, v2, v0, v1}, Lbutterknife/internal/Utils;->findRequiredViewAsType(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p1, Lcom/picacomic/fregata/activities/SplashActivity;->button_server1:Landroid/widget/Button;

    const-string v0, "field \'button_server2\'"

    .line 30
    const-class v1, Landroid/widget/Button;

    const v2, 0x7f09008c

    invoke-static {p2, v2, v0, v1}, Lbutterknife/internal/Utils;->findRequiredViewAsType(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p1, Lcom/picacomic/fregata/activities/SplashActivity;->button_server2:Landroid/widget/Button;

    const-string v0, "field \'button_server3\'"

    .line 31
    const-class v1, Landroid/widget/Button;

    const v2, 0x7f09008d

    invoke-static {p2, v2, v0, v1}, Lbutterknife/internal/Utils;->findRequiredViewAsType(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p1, Lcom/picacomic/fregata/activities/SplashActivity;->button_server3:Landroid/widget/Button;

    const-string v0, "field \'button_error\'"

    .line 32
    const-class v1, Landroid/widget/Button;

    const v2, 0x7f09008a

    invoke-static {p2, v2, v0, v1}, Lbutterknife/internal/Utils;->findRequiredViewAsType(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Landroid/widget/Button;

    iput-object p2, p1, Lcom/picacomic/fregata/activities/SplashActivity;->button_error:Landroid/widget/Button;

    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2
    .annotation build Landroid/support/annotation/CallSuper;
    .end annotation

    .line 38
    iget-object v0, p0, Lcom/picacomic/fregata/activities/SplashActivity_ViewBinding;->iZ:Lcom/picacomic/fregata/activities/SplashActivity;

    if-eqz v0, :cond_0

    const/4 v1, 0x0

    .line 40
    iput-object v1, p0, Lcom/picacomic/fregata/activities/SplashActivity_ViewBinding;->iZ:Lcom/picacomic/fregata/activities/SplashActivity;

    .line 42
    iput-object v1, v0, Lcom/picacomic/fregata/activities/SplashActivity;->linearLayout_options:Landroid/widget/LinearLayout;

    .line 43
    iput-object v1, v0, Lcom/picacomic/fregata/activities/SplashActivity;->linearLayout_error:Landroid/widget/LinearLayout;

    .line 44
    iput-object v1, v0, Lcom/picacomic/fregata/activities/SplashActivity;->button_server1:Landroid/widget/Button;

    .line 45
    iput-object v1, v0, Lcom/picacomic/fregata/activities/SplashActivity;->button_server2:Landroid/widget/Button;

    .line 46
    iput-object v1, v0, Lcom/picacomic/fregata/activities/SplashActivity;->button_server3:Landroid/widget/Button;

    .line 47
    iput-object v1, v0, Lcom/picacomic/fregata/activities/SplashActivity;->button_error:Landroid/widget/Button;

    return-void

    .line 39
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
