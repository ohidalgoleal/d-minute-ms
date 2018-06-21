webpackJsonp(["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncatched exception popping up in devtools
	return Promise.resolve().then(function() {
		throw new Error("Cannot find module '" + req + "'.");
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/app.component.html":
/***/ (function(module, exports) {

module.exports = "<app-spinner></app-spinner>\r\n<router-outlet></router-outlet>\r\n\r\n"

/***/ }),

/***/ "./src/app/app.component.scss":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/app.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_material__ = __webpack_require__("./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_platform_browser__ = __webpack_require__("./node_modules/@angular/platform-browser/esm5/platform-browser.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var AppComponent = /** @class */ (function () {
    function AppComponent(domSanitizer, matIconRegistry) {
        this.domSanitizer = domSanitizer;
        this.matIconRegistry = matIconRegistry;
        //add custom material icons
        matIconRegistry.addSvgIcon('delete', domSanitizer.bypassSecurityTrustResourceUrl('assets/img/icons/delete-empty.svg'));
        matIconRegistry.addSvgIcon('email', domSanitizer.bypassSecurityTrustResourceUrl('assets/img/icons/email.svg'));
        matIconRegistry.addSvgIcon('password', domSanitizer.bypassSecurityTrustResourceUrl('assets/img/icons/lock-question.svg'));
    }
    AppComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-root',
            template: __webpack_require__("./src/app/app.component.html"),
            styles: [__webpack_require__("./src/app/app.component.scss")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__angular_platform_browser__["c" /* DomSanitizer */],
            __WEBPACK_IMPORTED_MODULE_1__angular_material__["f" /* MatIconRegistry */]])
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__("./node_modules/@angular/platform-browser/esm5/platform-browser.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_forms__ = __webpack_require__("./node_modules/@angular/forms/esm5/forms.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_common_http__ = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_material__ = __webpack_require__("./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__angular_material_input__ = __webpack_require__("./node_modules/@angular/material/esm5/input.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__angular_material_toolbar__ = __webpack_require__("./node_modules/@angular/material/esm5/toolbar.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__angular_material_icon__ = __webpack_require__("./node_modules/@angular/material/esm5/icon.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__angular_material_card__ = __webpack_require__("./node_modules/@angular/material/esm5/card.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__angular_material_divider__ = __webpack_require__("./node_modules/@angular/material/esm5/divider.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__angular_material_list__ = __webpack_require__("./node_modules/@angular/material/esm5/list.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__angular_material_dialog__ = __webpack_require__("./node_modules/@angular/material/esm5/dialog.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__angular_material_select__ = __webpack_require__("./node_modules/@angular/material/esm5/select.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14__angular_material_progress_spinner__ = __webpack_require__("./node_modules/@angular/material/esm5/progress-spinner.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_15__angular_material_tabs__ = __webpack_require__("./node_modules/@angular/material/esm5/tabs.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_16__angular_material_checkbox__ = __webpack_require__("./node_modules/@angular/material/esm5/checkbox.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_17__angular_cdk_overlay__ = __webpack_require__("./node_modules/@angular/cdk/esm5/overlay.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_18__angular_cdk_portal__ = __webpack_require__("./node_modules/@angular/cdk/esm5/portal.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_19__angular_platform_browser_animations__ = __webpack_require__("./node_modules/@angular/platform-browser/esm5/animations.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_20_app_app_component__ = __webpack_require__("./src/app/app.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_21_app_session_toolbar_session_component__ = __webpack_require__("./src/app/session/toolbar/session.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_22_app_session_sign_on_sign_on_component__ = __webpack_require__("./src/app/session/sign-on/sign-on.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_23_app_session_sign_in_sign_in_component__ = __webpack_require__("./src/app/session/sign-in/sign-in.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_24_app_projects_project_list_project_list_component__ = __webpack_require__("./src/app/projects/project-list/project-list.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_25_app_projects_project_details_project_details_component__ = __webpack_require__("./src/app/projects/project-details/project-details.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_26__share_spinner_spinner_component__ = __webpack_require__("./src/app/share/spinner/spinner.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_27_app_share_constants_restPath__ = __webpack_require__("./src/app/share/constants/restPath.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_28_app_models_project__ = __webpack_require__("./src/app/models/project.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_29_app_models_user__ = __webpack_require__("./src/app/models/user.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_30_app_models_reunion__ = __webpack_require__("./src/app/models/reunion.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_31_app_models_usuario__ = __webpack_require__("./src/app/models/usuario.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_32_app_session_service_session_service__ = __webpack_require__("./src/app/session/service/session.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_33_app_projects_service_projects_service_service__ = __webpack_require__("./src/app/projects/service/projects-service.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_34_app_user_service_users_service__ = __webpack_require__("./src/app/user/service/users.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_35_app_share_spinner_spinner_service__ = __webpack_require__("./src/app/share/spinner/spinner.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_36_app_interceptors_auth_interceptor_service__ = __webpack_require__("./src/app/interceptors/auth-interceptor.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_37_app_share_guards_authenticate_guard__ = __webpack_require__("./src/app/share/guards/authenticate-guard.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_38__user_users_list_users_list_component__ = __webpack_require__("./src/app/user/users-list/users-list.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_39__user_create_user_create_user_component__ = __webpack_require__("./src/app/user/create-user/create-user.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


















//CDK



//Components







//Modelos





//Services




//Interceptors

//Guards



var appRoutes = [
    { path: 'sign-in', component: __WEBPACK_IMPORTED_MODULE_23_app_session_sign_in_sign_in_component__["a" /* SignInComponent */] },
    { path: 'sign-on', component: __WEBPACK_IMPORTED_MODULE_22_app_session_sign_on_sign_on_component__["a" /* SignOnComponent */] },
    { path: '', redirectTo: '/sign-on', pathMatch: 'full' },
    { path: 'project-list', component: __WEBPACK_IMPORTED_MODULE_24_app_projects_project_list_project_list_component__["b" /* ProjectListComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_37_app_share_guards_authenticate_guard__["a" /* authGuard */]] },
    { path: 'project/:id', component: __WEBPACK_IMPORTED_MODULE_25_app_projects_project_details_project_details_component__["b" /* ProjectDetailsComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_37_app_share_guards_authenticate_guard__["a" /* authGuard */]] }
];
var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["K" /* NgModule */])({
            entryComponents: [__WEBPACK_IMPORTED_MODULE_24_app_projects_project_list_project_list_component__["a" /* AddProjectDialog */], __WEBPACK_IMPORTED_MODULE_25_app_projects_project_details_project_details_component__["a" /* Atendants */], __WEBPACK_IMPORTED_MODULE_26__share_spinner_spinner_component__["a" /* SpinnerComponent */], __WEBPACK_IMPORTED_MODULE_39__user_create_user_create_user_component__["a" /* CreateUserComponent */]],
            declarations: [
                __WEBPACK_IMPORTED_MODULE_20_app_app_component__["a" /* AppComponent */],
                __WEBPACK_IMPORTED_MODULE_21_app_session_toolbar_session_component__["a" /* SessionComponent */],
                __WEBPACK_IMPORTED_MODULE_22_app_session_sign_on_sign_on_component__["a" /* SignOnComponent */],
                __WEBPACK_IMPORTED_MODULE_23_app_session_sign_in_sign_in_component__["a" /* SignInComponent */],
                __WEBPACK_IMPORTED_MODULE_24_app_projects_project_list_project_list_component__["b" /* ProjectListComponent */],
                __WEBPACK_IMPORTED_MODULE_24_app_projects_project_list_project_list_component__["a" /* AddProjectDialog */],
                __WEBPACK_IMPORTED_MODULE_26__share_spinner_spinner_component__["a" /* SpinnerComponent */],
                __WEBPACK_IMPORTED_MODULE_25_app_projects_project_details_project_details_component__["b" /* ProjectDetailsComponent */],
                __WEBPACK_IMPORTED_MODULE_25_app_projects_project_details_project_details_component__["a" /* Atendants */],
                __WEBPACK_IMPORTED_MODULE_38__user_users_list_users_list_component__["a" /* UsersListComponent */],
                __WEBPACK_IMPORTED_MODULE_39__user_create_user_create_user_component__["a" /* CreateUserComponent */]
            ],
            imports: [
                __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["a" /* BrowserModule */],
                __WEBPACK_IMPORTED_MODULE_19__angular_platform_browser_animations__["a" /* BrowserAnimationsModule */],
                __WEBPACK_IMPORTED_MODULE_3__angular_forms__["h" /* ReactiveFormsModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["c" /* HttpClientModule */],
                __WEBPACK_IMPORTED_MODULE_2__angular_router__["c" /* RouterModule */].forRoot(appRoutes, { enableTracing: false }),
                __WEBPACK_IMPORTED_MODULE_6__angular_material_input__["b" /* MatInputModule */],
                __WEBPACK_IMPORTED_MODULE_5__angular_material__["c" /* MatButtonModule */],
                __WEBPACK_IMPORTED_MODULE_8__angular_material_icon__["a" /* MatIconModule */],
                __WEBPACK_IMPORTED_MODULE_7__angular_material_toolbar__["a" /* MatToolbarModule */],
                __WEBPACK_IMPORTED_MODULE_9__angular_material_card__["a" /* MatCardModule */],
                __WEBPACK_IMPORTED_MODULE_10__angular_material_divider__["a" /* MatDividerModule */],
                __WEBPACK_IMPORTED_MODULE_11__angular_material_list__["a" /* MatListModule */],
                __WEBPACK_IMPORTED_MODULE_12__angular_material_dialog__["c" /* MatDialogModule */],
                __WEBPACK_IMPORTED_MODULE_13__angular_material_select__["a" /* MatSelectModule */],
                __WEBPACK_IMPORTED_MODULE_14__angular_material_progress_spinner__["a" /* MatProgressSpinnerModule */],
                __WEBPACK_IMPORTED_MODULE_17__angular_cdk_overlay__["f" /* OverlayModule */],
                __WEBPACK_IMPORTED_MODULE_18__angular_cdk_portal__["g" /* PortalModule */],
                __WEBPACK_IMPORTED_MODULE_15__angular_material_tabs__["a" /* MatTabsModule */],
                __WEBPACK_IMPORTED_MODULE_16__angular_material_checkbox__["a" /* MatCheckboxModule */]
            ],
            providers: [
                {
                    provide: __WEBPACK_IMPORTED_MODULE_5__angular_material__["b" /* MAT_LABEL_GLOBAL_OPTIONS */], useValue: { float: 'always' }
                }, {
                    provide: __WEBPACK_IMPORTED_MODULE_17__angular_cdk_overlay__["e" /* OverlayContainer */], useClass: __WEBPACK_IMPORTED_MODULE_17__angular_cdk_overlay__["b" /* FullscreenOverlayContainer */]
                }, {
                    provide: __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["a" /* HTTP_INTERCEPTORS */],
                    useClass: __WEBPACK_IMPORTED_MODULE_36_app_interceptors_auth_interceptor_service__["a" /* AuthInterceptorService */],
                    multi: true
                },
                __WEBPACK_IMPORTED_MODULE_32_app_session_service_session_service__["a" /* SessionService */],
                __WEBPACK_IMPORTED_MODULE_27_app_share_constants_restPath__["a" /* restPath */],
                __WEBPACK_IMPORTED_MODULE_28_app_models_project__["a" /* Project */],
                __WEBPACK_IMPORTED_MODULE_29_app_models_user__["a" /* User */],
                __WEBPACK_IMPORTED_MODULE_31_app_models_usuario__["a" /* Usuario */],
                __WEBPACK_IMPORTED_MODULE_30_app_models_reunion__["a" /* Reunion */],
                __WEBPACK_IMPORTED_MODULE_33_app_projects_service_projects_service_service__["a" /* ProjectsService */],
                __WEBPACK_IMPORTED_MODULE_34_app_user_service_users_service__["a" /* UsersService */],
                __WEBPACK_IMPORTED_MODULE_37_app_share_guards_authenticate_guard__["a" /* authGuard */],
                __WEBPACK_IMPORTED_MODULE_35_app_share_spinner_spinner_service__["a" /* SpinnerService */]
            ],
            bootstrap: [__WEBPACK_IMPORTED_MODULE_20_app_app_component__["a" /* AppComponent */]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/interceptors/auth-interceptor.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AuthInterceptorService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_app_session_service_session_service__ = __webpack_require__("./src/app/session/service/session.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_do__ = __webpack_require__("./node_modules/rxjs/_esm5/add/operator/do.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_router__ = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__share_spinner_spinner_service__ = __webpack_require__("./src/app/share/spinner/spinner.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};







var AuthInterceptorService = /** @class */ (function () {
    function AuthInterceptorService(auth, route, spinner) {
        this.auth = auth;
        this.route = route;
        this.spinner = spinner;
    }
    AuthInterceptorService.prototype.goodByeDude = function () {
        this.auth.resetToken();
        this.route.navigate(['/sign-on']);
    };
    AuthInterceptorService.prototype.intercept = function (request, next) {
        var _this = this;
        if (!request.url.match('/token/generate-token') && request['responseType'] === 'json') {
            this.auth.getToken() === undefined || this.auth.getToken() === "undefined" ? this.goodByeDude() : undefined;
            request = request.clone({
                setHeaders: {
                    Authorization: "Bearer " + this.auth.getToken()
                }
            });
        }
        if (request instanceof __WEBPACK_IMPORTED_MODULE_1__angular_common_http__["d" /* HttpRequest */] && request['responseType'] === 'json') {
            this.spinner.show();
        }
        return next.handle(request).do(function (event) {
            //Everything is cool
            if (event instanceof __WEBPACK_IMPORTED_MODULE_1__angular_common_http__["e" /* HttpResponse */]) {
                _this.spinner.hide();
            }
        }, function (err) {
            _this.spinner.hide();
            //You fuck up
            if (err['status'] === 401) {
                console.log('You are banished from the app');
                _this.goodByeDude();
            }
        });
    };
    AuthInterceptorService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2_app_session_service_session_service__["a" /* SessionService */], __WEBPACK_IMPORTED_MODULE_4__angular_router__["b" /* Router */], __WEBPACK_IMPORTED_MODULE_5__share_spinner_spinner_service__["a" /* SpinnerService */]])
    ], AuthInterceptorService);
    return AuthInterceptorService;
}());



/***/ }),

/***/ "./src/app/models/project.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Project; });
var Project = /** @class */ (function () {
    function Project() {
    }
    return Project;
}());



/***/ }),

/***/ "./src/app/models/reunion.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Reunion; });
var Reunion = /** @class */ (function () {
    function Reunion() {
    }
    return Reunion;
}());



/***/ }),

/***/ "./src/app/models/user.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return User; });
var User = /** @class */ (function () {
    function User() {
    }
    return User;
}());



/***/ }),

/***/ "./src/app/models/usuario.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Usuario; });
var Usuario = /** @class */ (function () {
    function Usuario() {
    }
    return Usuario;
}());



/***/ }),

/***/ "./src/app/projects/project-details/atttendants-details-dialog.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\r\n    <div class=\"row\">\r\n        <div class=\"col-md-12\">\r\n            <h2>Lista de Asistentes</h2>\r\n        </div>\r\n        <div class=\"col-md-12\">\r\n            <mat-nav-list dense>\r\n                <a mat-list-item *ngFor=\"let attendant of listOfAttendants\"> {{attendant.nombre}} </a>\r\n            </mat-nav-list>\r\n        </div>\r\n        <div class=\"col-md-12\">\r\n            <button mat-raised-button type=\"button\" (click)=\"editAttendants()\">Editar Asistentes</button>\r\n        </div>\r\n    </div>\r\n    <div class=\"col-md-12 formContainer\">\r\n        <app-users-list #userList *ngIf=\"edit\" (onSubmit)=\"submitList($event)\">\r\n        </app-users-list>\r\n    </div>\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/projects/project-details/atttendants-details-dialog.scss":
/***/ (function(module, exports) {

module.exports = ".formContainer {\n  padding: 2em 1em;\n  margin: 0 auto;\n  display: block; }\n\nh2 {\n  text-align: center; }\n"

/***/ }),

/***/ "./src/app/projects/project-details/project-details.component.html":
/***/ (function(module, exports) {

module.exports = "<app-session></app-session>\r\n<div class=\"details-container\">\r\n  <mat-card *ngIf=\"project !== undefined\">\r\n    <mat-card-content>\r\n      <h2>Projecto: {{project.descripcion}}</h2>\r\n      <mat-tab-group>\r\n        <mat-tab label=\"Reuniones\">\r\n          <div class=\"details-container-mettings\">\r\n            <div class=\"meeting-menu\">\r\n              <button mat-raised-button class=\"addMeetingButton\" (click)=\"switchPostMeeting()\" type=\"button\">\r\n                Nueva Reunion\r\n              </button>\r\n              <div class=\"meeting-list\">\r\n                <div class=\"meeting-items\" *ngFor=\"let reu of reuniones\"> \r\n                  <a class=\"meeting-item\" (click)=\"selectMeeting(reu)\" [class.selected]=\"wasClicked\">{{reu.resumen}}</a>\r\n                </div>\r\n              </div>\r\n            </div>\r\n            <div class=\"meeting-detail\">\r\n              <div class=\"meeting-detail-options\">\r\n                <a (click)=\"displayAttendants()\">Lista de Asistentes</a>\r\n                <button mat-icon-button>\r\n                  <mat-icon aria-label=\"Example icon-button with a heart icon\">add</mat-icon>\r\n                </button>\r\n                <button mat-icon-button>\r\n                  <mat-icon aria-label=\"Example icon-button with a heart icon\">edit</mat-icon>\r\n                </button>\r\n                <button mat-icon-button>\r\n                  <mat-icon aria-label=\"Example icon-button with a heart icon\">delete</mat-icon>\r\n                </button>\r\n              </div>\r\n              <div class=\"meeting-detail-titulo\" *ngIf=\"selectedMeeting !== undefined\">\r\n                <p>REUNIÓN {{ selectedMeeting.fecha }}</p>\r\n                <p><b>OBJETIVO:</b> {{ selectedMeeting.resumen }}</p>\r\n              </div>\r\n              <div class=\"meeting-detail-body\" [ngSwitch]=\"saving\">\r\n                <div class=\"formActa\" *ngSwitchCase=\"true\">\r\n                  <form [formGroup]=\"addMeetingForm\" (ngSubmit)=\"crearReunion()\">\r\n                    <h1>Agregar Acta</h1>\r\n                    <div class=\"row\">\r\n                      <div class=\"col-md-12\">\r\n                        <mat-form-field>\r\n                          <input matInput placeholder=\"Resumen\" formControlName=\"resumen\" [(ngModel)]=\"Reunion.resumen\" type=\"text\">\r\n                        </mat-form-field>\r\n                        <mat-form-field>\r\n                          <input matInput placeholder=\"Fecha\" formControlName=\"fecha\" [(ngModel)]=\"Reunion.fecha\" type=\"date\">\r\n                        </mat-form-field>\r\n                      </div>\r\n                      <div class=\"col-md-12\">\r\n                        <mat-form-field>\r\n                          <mat-select placeholder=\"Miembros del Equipo\" [(ngModel)]=\"selectedMember\" formControlName=\"selectedMember\">\r\n                            <mat-option *ngFor=\"let user of listOfUsers\" [value]=\"user\">\r\n                              {{ user.fullName }}\r\n                            </mat-option>\r\n                          </mat-select>\r\n                        </mat-form-field>\r\n                        <mat-list *ngIf=\"Reunion.usuarioActa.length > 0\">\r\n                          <h3 mat-subheader>Miembros</h3>\r\n                          <mat-list-item *ngFor=\"let member of Reunion.usuarioActa\">\r\n                            <h4 mat-line>{{ member.nombre }}</h4>\r\n                            <p mat-line> {{ member.username }} </p>\r\n                            <button mat-raised-button type=\"button\" class=\"deleteMember\" (click)=\"deleteMember(member)\">\r\n                              <mat-icon svgIcon=\"delete\"></mat-icon>\r\n                            </button>\r\n                          </mat-list-item>\r\n                        </mat-list>\r\n                        <div class=\"col-md-12\">\r\n                          <button mat-raised-button type=\"button\" (click)=\"addMember()\">Agregar Miembro</button>\r\n                          \r\n                        </div>\r\n                      </div>\r\n                      <div class=\"col-md-12\">\r\n                        <h3 mat-subheader>Tema</h3>\r\n                      </div>\r\n                      <div class=\"col-md-12\">\r\n                        <div formArrayName=\"temaActa\" *ngFor=\"let item of addMeetingForm.get('temaActa').controls; let i = index;\">\r\n                          <div [formGroupName]=\"i\">\r\n                            <mat-form-field>\r\n                              <input matInput placeholder=\"Nombre\" formControlName=\"nombre\" type=\"text\">\r\n                            </mat-form-field>\r\n                            <mat-form-field>\r\n                              <input matInput placeholder=\"Discusion\" formControlName=\"discusion\" type=\"text\">\r\n                            </mat-form-field>\r\n                            <button mat-raised-button type=\"button\" (click)=\"addTheme()\">Agregar Tema</button>\r\n                          </div>\r\n                        </div>\r\n                      </div>\r\n                      <div class=\"col-md-12\">\r\n                        <button mat-raised-button type=\"submit\">Agregar Acta</button>\r\n                      </div>\r\n                    </div>\r\n                    </form>\r\n                </div>\r\n                <div *ngSwitchCase=\"false\">\r\n                  <h5>Memoria sección Investigación</h5>\r\n                  <p>Se conversa sobre los pasos a seguir en la tesis y que es lo que debemos abordar de forma inicial. El marco teórico sera\r\n                    lo primero que debemos abordar del cual se define que: no es un conjunto de definiciones, mas bien una elaboración de\r\n                    un cuento donde estén representados los conceptos es decir crear una narrativa del problema.</p>\r\n                  <mat-list *ngIf=\"selectedMeeting !== undefined && selectedMeeting.temaActa.length > 0\">\r\n                    <h3 mat-subheader>Temas</h3>\r\n                    <mat-list-item *ngFor=\"let theme of selectedMeeting.temaActa\">\r\n                      <p mat-line>\r\n                        {{theme.nombre}}{{theme.discusion}}\r\n                      </p>\r\n                    </mat-list-item>\r\n                  </mat-list>\r\n                </div>\r\n              </div>\r\n            </div>\r\n          </div>\r\n        </mat-tab>\r\n        <mat-tab label=\"Tablero Kanban\" disabled>\r\n          <div>\r\n            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla venenatis ante augue. Phasellus volutpat neque ac dui mattis\r\n            vulputate. Etiam consequat aliquam cursus. In sodales pretium ultrices. Maecenas lectus est, sollicitudin consectetur\r\n            felis nec, feugiat ultricies mi. Aliquam erat volutpat. Nam placerat, tortor in ultrices porttitor, orci enim rutrum\r\n            enim, vel tempor sapien arcu a tellus.\r\n          </div>\r\n        </mat-tab>\r\n        <mat-tab label=\"Trazabilidad\" disabled>\r\n          Lorem ipsum dolor sit amet, consectetur adipisicing elit. Optio quibusdam accusantium inventore, atque cum nam harum quas aliquid necessitatibus mollitia voluptate praesentium? Voluptatem ut illo voluptas tempore sequi, nobis cumque!\r\n        </mat-tab>\r\n      </mat-tab-group>\r\n    </mat-card-content>\r\n  </mat-card>\r\n</div>"

/***/ }),

/***/ "./src/app/projects/project-details/project-details.component.scss":
/***/ (function(module, exports) {

module.exports = ".details-container {\n  display: block;\n  margin: 1em auto;\n  border-radius: 5px;\n  width: 80%; }\n  .details-container h2 {\n    text-align: center;\n    font-size: 1.5em; }\n  .details-container .addMeetingButton {\n    background-color: #1EAAF1;\n    color: #FFFFFF;\n    display: block;\n    margin: 1em auto; }\n  .details-container-mettings {\n    width: 100%; }\n  .details-container-mettings .meeting-list {\n      border: 1px solid rgba(0, 0, 0, 0.12);\n      border-radius: 5px; }\n  .details-container-mettings .meeting-list .meeting-items {\n        padding: 10px;\n        white-space: initial;\n        border-bottom: 1px solid rgba(0, 0, 0, 0.12); }\n  .details-container-mettings .meeting-list .meeting-item {\n        cursor: pointer; }\n  .details-container-mettings .meeting-menu {\n      float: left;\n      margin: 1em 1em 1em;\n      max-width: 20%;\n      font-size: 10px; }\n  .details-container-mettings .meeting-detail {\n      font-family: Roboto, sanserif;\n      float: left;\n      width: 69%;\n      padding: 1em;\n      border-left: 1px solid rgba(0, 0, 0, 0.12); }\n  .details-container-mettings .meeting-detail-body .formActa {\n        border-top: 1px solid rgba(0, 0, 0, 0.12); }\n  .details-container-mettings .meeting-detail-body .formActa h1 {\n          padding: 1em 0;\n          text-align: center;\n          font-size: 1.5em;\n          text-decoration: underline; }\n  .details-container-mettings .meeting-detail-options {\n        position: relative;\n        float: right;\n        left: 20%; }\n  .details-container-mettings .meeting-detail-options a {\n          cursor: pointer; }\n  .details-container-mettings .meeting-detail-titulo {\n        text-align: center; }\n  .isSecretary {\n  margin-right: 2em;\n  margin-top: 1em; }\n  .selectedElement {\n  background-color: #1EAAF1;\n  color: #FFFFFF; }\n"

/***/ }),

/***/ "./src/app/projects/project-details/project-details.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "b", function() { return ProjectDetailsComponent; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Atendants; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_app_projects_service_projects_service_service__ = __webpack_require__("./src/app/projects/service/projects-service.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_app_user_service_users_service__ = __webpack_require__("./src/app/user/service/users.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_router__ = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_material__ = __webpack_require__("./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_rxjs_add_operator_switchMap__ = __webpack_require__("./node_modules/rxjs/_esm5/add/operator/switchMap.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_app_models_reunion__ = __webpack_require__("./src/app/models/reunion.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__angular_forms__ = __webpack_require__("./node_modules/@angular/forms/esm5/forms.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8_app_user_users_list_users_list_component__ = __webpack_require__("./src/app/user/users-list/users-list.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};









var ProjectDetailsComponent = /** @class */ (function () {
    function ProjectDetailsComponent(projectService, userService, route, Reunion, fb, dialog) {
        this.projectService = projectService;
        this.userService = userService;
        this.route = route;
        this.Reunion = Reunion;
        this.fb = fb;
        this.dialog = dialog;
        this.activeMeeting = undefined;
        this.themeCounter = 0;
        this.Reunion.usuarioActa = [];
    }
    ProjectDetailsComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.saving = false;
        this.route.paramMap.switchMap(function (params) {
            return _this.projectService.getProjectById(params.get('id'));
        }).subscribe(function (response) {
            _this.projectId = response['proyectoId'];
            _this.project = response;
            _this.project !== undefined ? _this.listarReuniones() : undefined;
        }, function (err) {
            console.log(err);
        });
        this.getListUsers();
        this.createMeetingForm();
    };
    ProjectDetailsComponent.prototype.switchPostMeeting = function () {
        this.saving = true;
    };
    ProjectDetailsComponent.prototype.createMeetingForm = function () {
        this.addMeetingForm = this.fb.group({
            fecha: [this.Reunion.fecha, __WEBPACK_IMPORTED_MODULE_7__angular_forms__["i" /* Validators */].required],
            resumen: [this.Reunion.resumen, __WEBPACK_IMPORTED_MODULE_7__angular_forms__["i" /* Validators */].required],
            usuarioActa: [this.Reunion.usuarioActa, __WEBPACK_IMPORTED_MODULE_7__angular_forms__["i" /* Validators */].required],
            temaActa: this.fb.array([this.createTheme()]),
            selectedMember: [this.selectedMember]
        });
    };
    ProjectDetailsComponent.prototype.createTheme = function () {
        return this.fb.group({
            id: this.themeCounter++,
            nombre: '',
            discusion: '',
            actaId: 0
        });
    };
    ProjectDetailsComponent.prototype.addTheme = function () {
        this.temaSelectedActa = this.addMeetingForm.get('temaActa');
        this.temaSelectedActa.push(this.createTheme());
    };
    ProjectDetailsComponent.prototype.addMember = function () {
        if (this.selectedMember != undefined && !this.Reunion.usuarioActa.includes(this.selectedMember)) {
            this.Reunion.usuarioActa.push(this.selectedMember);
            var index = this.listOfUsers.indexOf(this.selectedMember);
            this.listOfUsers.splice(index, 1);
            this.selectedMember = undefined;
        }
    };
    ProjectDetailsComponent.prototype.deleteMember = function (miembro) {
        var index = this.Reunion.usuarioActa.indexOf(miembro);
        index > -1 ? this.Reunion.usuarioActa.splice(index, 1) : console.log('Member Not Found');
    };
    ProjectDetailsComponent.prototype.crearReunion = function () {
        var _this = this;
        this.Reunion.usuarioActa = this.Reunion.usuarioActa.map(function (cv, index) { return (Object.assign({ secretario: 'N', asiste: 'S' }, { username: cv.username })); });
        this.Reunion.temaActa = this.temaSelectedActa.value;
        this.temaSelectedActa.reset();
        var payload = Object.assign({ proyectoId: this.projectId }, this.Reunion);
        console.log(payload);
        this.projectService.postReunion(payload)
            .subscribe(function (response) {
            console.log(response);
            _this.saving = false;
            _this.listarReuniones();
        }), function (err) {
            console.log(err);
        };
    };
    ProjectDetailsComponent.prototype.listarReuniones = function () {
        var _this = this;
        this.projectService.listReunion(this.project.proyectoId).subscribe(function (response) {
            _this.reuniones = response;
            _this.activeMeeting = _this.reuniones.length > 0 ? _this.reuniones[0] : undefined;
            _this.saving = _this.reuniones.length === 0 || _this.reuniones.length === undefined ? true : false;
            _this.selectMeeting();
        }, function (err) {
            console.log(err);
        });
    };
    ProjectDetailsComponent.prototype.getListUsers = function () {
        var _this = this;
        this.userService.getListUsers().subscribe(function (response) {
            _this.listOfUsers = response.map(function (cv) {
                return Object.assign({ fullName: cv['nombre'] + " " + cv['apellido'] }, cv);
            });
        }, function (err) {
            console.log(err);
        });
    };
    ProjectDetailsComponent.prototype.selectMeeting = function (acta) {
        if (acta === void 0) { acta = undefined; }
        if (acta === undefined && this.reuniones.length > 0) {
            this.selectedMeeting = this.reuniones[0];
        }
        else if (acta !== undefined) {
            this.selectedMeeting = acta;
        }
        this.selectedMeeting !== undefined && this.selectedMeeting['actaId'] !== undefined ? this.getActaById(this.selectedMeeting['actaId']) : undefined;
    };
    ProjectDetailsComponent.prototype.getActaById = function (actaId) {
        var _this = this;
        this.projectService.getReunionById(actaId).subscribe(function (data) {
            _this.selectedMeeting = data;
        }, function (err) {
            console.log(err);
        });
    };
    ProjectDetailsComponent.prototype.displayAttendants = function () {
        var dialogRef = this.dialog.open(Atendants, {
            width: '80%',
            height: '80%',
            data: { id: this.selectedMeeting['actaId'] }
        });
    };
    ProjectDetailsComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-project-details',
            template: __webpack_require__("./src/app/projects/project-details/project-details.component.html"),
            styles: [__webpack_require__("./src/app/projects/project-details/project-details.component.scss")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_app_projects_service_projects_service_service__["a" /* ProjectsService */],
            __WEBPACK_IMPORTED_MODULE_2_app_user_service_users_service__["a" /* UsersService */], __WEBPACK_IMPORTED_MODULE_3__angular_router__["a" /* ActivatedRoute */],
            __WEBPACK_IMPORTED_MODULE_6_app_models_reunion__["a" /* Reunion */], __WEBPACK_IMPORTED_MODULE_7__angular_forms__["b" /* FormBuilder */], __WEBPACK_IMPORTED_MODULE_4__angular_material__["d" /* MatDialog */]])
    ], ProjectDetailsComponent);
    return ProjectDetailsComponent;
}());

var Atendants = /** @class */ (function () {
    function Atendants(dialogRef, projectService, route, data) {
        this.dialogRef = dialogRef;
        this.projectService = projectService;
        this.route = route;
        this.edit = false;
        this.actaId = data.id;
    }
    Atendants.prototype.ngAfterContentInit = function () {
        this.getAttendantList();
    };
    Atendants.prototype.getAttendantList = function () {
        var _this = this;
        //Ugly solution
        setTimeout(function () {
            _this.projectService.getReunionById(_this.actaId).subscribe(function (data) {
                _this.acta = data;
                _this.listOfAttendants = data['usuarioActa'];
            }, function (err) {
                console.log(err);
            });
        }, 0);
    };
    Atendants.prototype.submitList = function (event) {
        var _this = this;
        if (event) {
            var fixedacta = this.userListComponent.listOfSelectedUsers.map(function (usuario, index) {
                delete usuario['fullName'];
                return usuario;
            });
            this.acta['usuarioActa'] = fixedacta;
            this.projectService.postReunion(this.acta).subscribe(function (data) {
                _this.userListComponent.listOfSelectedUsers = [];
                console.log(data);
            }, function (err) {
                console.log(err);
            });
        }
    };
    Atendants.prototype.editAttendants = function () {
        this.edit = true;
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_11" /* ViewChild */])(__WEBPACK_IMPORTED_MODULE_8_app_user_users_list_users_list_component__["a" /* UsersListComponent */]),
        __metadata("design:type", __WEBPACK_IMPORTED_MODULE_8_app_user_users_list_users_list_component__["a" /* UsersListComponent */])
    ], Atendants.prototype, "userListComponent", void 0);
    Atendants = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'atttendants-details-dialog',
            template: __webpack_require__("./src/app/projects/project-details/atttendants-details-dialog.html"),
            styles: [__webpack_require__("./src/app/projects/project-details/atttendants-details-dialog.scss")]
        }),
        __param(3, Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["B" /* Inject */])(__WEBPACK_IMPORTED_MODULE_4__angular_material__["a" /* MAT_DIALOG_DATA */])),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_4__angular_material__["e" /* MatDialogRef */],
            __WEBPACK_IMPORTED_MODULE_1_app_projects_service_projects_service_service__["a" /* ProjectsService */], __WEBPACK_IMPORTED_MODULE_3__angular_router__["a" /* ActivatedRoute */], Object])
    ], Atendants);
    return Atendants;
}());



/***/ }),

/***/ "./src/app/projects/project-list/add-project-dialog.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\r\n    <div class=\"row\">\r\n        <form action=\"\" [formGroup]=\"addProjectForm\" (ngSubmit)=\"postProject()\">\r\n            <div class=\"col-md-12\">\r\n                <h4>Agregar Proyecto</h4>\r\n                    <mat-icon aria-label=\"close\" class=\"closeModalButton\" (click)=\"onNoClick()\">close</mat-icon>\r\n                <mat-form-field>\r\n                    <input matInput placeholder=\"Nombre del Proyecto\" [(ngModel)]=\"Project.nombre\" formControlName=\"name\"  type=\"text\">\r\n                </mat-form-field>\r\n            </div>\r\n            <div class=\"col-md-12\">\r\n                <mat-form-field>\r\n                    <input matInput placeholder=\"Descripcion del Proyecto\" [(ngModel)]=\"Project.descripcion\" formControlName=\"description\" type=\"text\">\r\n                </mat-form-field>\r\n            </div>\r\n                <div class=\"col-md-12\">\r\n                    <mat-form-field>\r\n                        <input matInput placeholder=\"Fecha Inicio\" [(ngModel)]=\"Project.fechaInicio\" formControlName=\"startDate\" type=\"date\">\r\n                    </mat-form-field>\r\n                    <mat-form-field>\r\n                        <input matInput placeholder=\"Fecha Termino Estimada\" [(ngModel)]=\"Project.fechaFin\" formControlName=\"deathLine\" type=\"date\">\r\n                    </mat-form-field>\r\n                </div>\r\n                \r\n                <div class=\"col-md-12 memberPanel\">\r\n                    <div class=\"col-md-6\">\r\n                        <mat-form-field>\r\n                            <mat-select placeholder=\"Miembros del Equipo\" [(ngModel)]=\"selectedMember\" formControlName=\"selectedMember\">\r\n                                <mat-option *ngFor=\"let user of listOfUsers\" [value]=\"user\">\r\n                                    {{ user.fullName }}\r\n                                </mat-option>\r\n                            </mat-select>\r\n                        </mat-form-field>\r\n                        <button mat-raised-button type=\"button\" (click)= \"addMember()\">Agregar Miembro</button>\r\n                    </div>\r\n                    <div class=\"col-md-6\">\r\n                        <mat-list *ngIf=\"Project.usuariosNuevoProyecto.length > 0\">\r\n                            <h3 mat-subheader>Miembros</h3>\r\n                            <mat-list-item *ngFor=\"let member of Project.usuariosNuevoProyecto\">\r\n                                <h4 mat-line>{{ member.nombre }}</h4>\r\n                                <p mat-line> {{ member.username }} </p>\r\n                                <button mat-raised-button type=\"button\" class=\"deleteMember\"  (click)=\"deleteMember(member)\"><mat-icon svgIcon=\"delete\"></mat-icon></button>\r\n                            </mat-list-item>\r\n                        </mat-list>\r\n                    </div>\r\n                </div>\r\n                <mat-divider></mat-divider>\r\n                <div class=\"col-md-12\">\r\n                    <button mat-raised-button type=\"submit\" [disabled]=\"!addProjectForm.valid\">Crear nuevo proyecto</button>\r\n                </div>\r\n            </form>\r\n        </div>\r\n</div>"

/***/ }),

/***/ "./src/app/projects/project-list/add-project-dialog.scss":
/***/ (function(module, exports) {

module.exports = ":host {\n  display: block;\n  padding: 1em; }\n\nform {\n  width: 100%; }\n\nbutton {\n  margin: 0 auto;\n  color: white;\n  background-color: #21B3D8; }\n\nmat-divider {\n  margin-top: 1em;\n  margin-bottom: 1em; }\n\n.memberPanel {\n  display: -webkit-box;\n  display: -ms-flexbox;\n  display: flex; }\n\n.closeModalButton {\n  position: absolute;\n  margin-left: 97%;\n  bottom: 82%;\n  color: #B8B8B8;\n  background-color: #FFFFFF; }\n\nbutton.deleteMember.mat-button {\n  width: 16% !important;\n  height: 50% !important;\n  min-width: 0px !important;\n  background-color: red !important; }\n"

/***/ }),

/***/ "./src/app/projects/project-list/project-list.component.html":
/***/ (function(module, exports) {

module.exports = "<app-session></app-session>\r\n<div class=\"container\">\r\n  <div class=\"row\">\r\n    <div class=\"col-sm-12\">\r\n      <mat-card>\r\n        <mat-card-header>\r\n          <div class=\"row\">\r\n          <div mat-card-avatar></div>\r\n          <mat-card-title>Projectos Activos</mat-card-title>\r\n            <div class=\"col-sm-12\">\r\n              <button mat-raised-button (click)=\"openProyectDialog()\">Agregar Proyecto</button>\r\n              <button mat-raised-button (click)=\"openUserDialog()\">Agregar Usuario</button>\r\n            </div>\r\n          </div>\r\n        </mat-card-header>\r\n        <mat-card-content>\r\n\r\n          <mat-nav-list dense>\r\n            <a mat-list-item [routerLink]=\"['/project', project.proyectoId]\" *ngFor = \"let project of listArray\"> {{project.nombre}} </a>\r\n          </mat-nav-list>\r\n\r\n        </mat-card-content>\r\n        <mat-card-actions>\r\n        </mat-card-actions>\r\n      </mat-card>\r\n    </div>\r\n  </div>\r\n</div>"

/***/ }),

/***/ "./src/app/projects/project-list/project-list.component.scss":
/***/ (function(module, exports) {

module.exports = "mat-card {\n  margin-top: 2em; }\n\nmat-card-title {\n  font-size: 17px !important; }\n\nmat-card-header {\n  border-bottom: 1px solid gray; }\n\nmat-nav-list :-webkit-any-link {\n  border-bottom: 1px solid gray; }\n\nmat-nav-list :-moz-any-link {\n  border-bottom: 1px solid gray; }\n\nmat-nav-list :any-link {\n  border-bottom: 1px solid gray; }\n\nbutton {\n  margin-bottom: 1em;\n  height: auto;\n  padding: 0 1em;\n  width: auto;\n  color: white;\n  background-color: #21B3D8; }\n"

/***/ }),

/***/ "./src/app/projects/project-list/project-list.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "b", function() { return ProjectListComponent; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AddProjectDialog; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_app_projects_service_projects_service_service__ = __webpack_require__("./src/app/projects/service/projects-service.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_material__ = __webpack_require__("./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_app_user_service_users_service__ = __webpack_require__("./src/app/user/service/users.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_forms__ = __webpack_require__("./node_modules/@angular/forms/esm5/forms.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_app_models_project__ = __webpack_require__("./src/app/models/project.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_app_user_create_user_create_user_component__ = __webpack_require__("./src/app/user/create-user/create-user.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};







var ProjectListComponent = /** @class */ (function () {
    function ProjectListComponent(projectsService, dialog) {
        this.projectsService = projectsService;
        this.dialog = dialog;
    }
    ProjectListComponent.prototype.ngOnInit = function () {
        this.listAllProjects();
    };
    ProjectListComponent.prototype.listAllProjects = function () {
        var _this = this;
        this.projectsService.listProjects().subscribe(function (response) {
            _this.listArray = response;
        }, function (err) {
            console.log(err);
        });
    };
    ProjectListComponent.prototype.openProyectDialog = function () {
        var dialogRef = this.dialog.open(AddProjectDialog, {
            width: '80%',
            height: '60%',
            data: {}
        });
        dialogRef.componentInstance.saved.subscribe(this.reloadList.bind(this));
    };
    ProjectListComponent.prototype.openUserDialog = function () {
        var userDialogRef = this.dialog.open(__WEBPACK_IMPORTED_MODULE_6_app_user_create_user_create_user_component__["a" /* CreateUserComponent */], {
            width: '80%',
            height: '60%',
            data: {}
        });
        // dialogRef.componentInstance.saved.subscribe(this.reloadList.bind(this));
    };
    ProjectListComponent.prototype.reloadList = function (isPosted) {
        isPosted ? this.listAllProjects() : undefined;
    };
    ProjectListComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-project-list',
            template: __webpack_require__("./src/app/projects/project-list/project-list.component.html"),
            styles: [__webpack_require__("./src/app/projects/project-list/project-list.component.scss")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_app_projects_service_projects_service_service__["a" /* ProjectsService */], __WEBPACK_IMPORTED_MODULE_2__angular_material__["d" /* MatDialog */]])
    ], ProjectListComponent);
    return ProjectListComponent;
}());

var AddProjectDialog = /** @class */ (function () {
    function AddProjectDialog(dialogRef, UsersService, fb, Project, projectsService, data) {
        this.dialogRef = dialogRef;
        this.UsersService = UsersService;
        this.fb = fb;
        this.Project = Project;
        this.projectsService = projectsService;
        this.data = data;
        this.saved = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["x" /* EventEmitter */]();
        this.createProjectForm();
        this.Project.usuariosNuevoProyecto = [];
    }
    AddProjectDialog.prototype.ngOnInit = function () {
        var _this = this;
        setTimeout(function () {
            _this.UsersService.getListUsers().subscribe(function (response) {
                _this.listOfUsers = response.map(function (cv) {
                    return Object.assign({ fullName: cv['nombre'] + " " + cv['apellido'] }, cv);
                });
            }, function (err) {
                console.log(err);
            });
        }, 0);
    };
    AddProjectDialog.prototype.createProjectForm = function () {
        this.addProjectForm = this.fb.group({
            name: [this.Project.nombre, __WEBPACK_IMPORTED_MODULE_4__angular_forms__["i" /* Validators */].required],
            description: [this.Project.descripcion],
            startDate: [this.Project.fechaInicio, __WEBPACK_IMPORTED_MODULE_4__angular_forms__["i" /* Validators */].required],
            deathLine: [this.Project.fechaFin, __WEBPACK_IMPORTED_MODULE_4__angular_forms__["i" /* Validators */].required],
            usuariosNuevoProyecto: [this.Project.usuariosNuevoProyecto],
            selectedMember: [this.selectedMember]
        });
    };
    AddProjectDialog.prototype.addMember = function () {
        if (this.selectedMember != undefined && !this.Project.usuariosNuevoProyecto.includes(this.selectedMember)) {
            this.Project.usuariosNuevoProyecto.push(this.selectedMember);
            var index = this.listOfUsers.indexOf(this.selectedMember);
            this.listOfUsers.splice(index, 1);
            this.selectedMember = undefined;
        }
    };
    AddProjectDialog.prototype.onNoClick = function () {
        this.dialogRef.close();
    };
    AddProjectDialog.prototype.deleteMember = function (miembro) {
        var index = this.Project.usuariosNuevoProyecto.indexOf(miembro);
        index > -1 ? this.Project.usuariosNuevoProyecto.splice(index, 1) : console.log('Member Not Found');
    };
    AddProjectDialog.prototype.postProject = function () {
        var _this = this;
        if (this.addProjectForm.valid) {
            var postObject = Object.assign({}, this.Project);
            this.Project.usuariosNuevoProyecto = this.Project.usuariosNuevoProyecto.map(function (cv, i) {
                return { username: cv['username'] };
            });
            this.projectsService.addProject(this.Project).subscribe(function (response) {
                _this.onNoClick();
                _this.saved.emit(true);
                console.log(response);
            }, function (err) {
                console.log(err);
            });
        }
    };
    AddProjectDialog = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'add-project-dialog',
            template: __webpack_require__("./src/app/projects/project-list/add-project-dialog.html"),
            styles: [__webpack_require__("./src/app/projects/project-list/add-project-dialog.scss")]
        }),
        __param(5, Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["B" /* Inject */])(__WEBPACK_IMPORTED_MODULE_2__angular_material__["a" /* MAT_DIALOG_DATA */])),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__angular_material__["e" /* MatDialogRef */], __WEBPACK_IMPORTED_MODULE_3_app_user_service_users_service__["a" /* UsersService */],
            __WEBPACK_IMPORTED_MODULE_4__angular_forms__["b" /* FormBuilder */], __WEBPACK_IMPORTED_MODULE_5_app_models_project__["a" /* Project */], __WEBPACK_IMPORTED_MODULE_1_app_projects_service_projects_service_service__["a" /* ProjectsService */], Object])
    ], AddProjectDialog);
    return AddProjectDialog;
}());



/***/ }),

/***/ "./src/app/projects/service/projects-service.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ProjectsService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_app_session_service_session_service__ = __webpack_require__("./src/app/session/service/session.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_common_http__ = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_app_share_constants_restPath__ = __webpack_require__("./src/app/share/constants/restPath.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var ProjectsService = /** @class */ (function () {
    function ProjectsService(sessionService, http, restPath) {
        this.sessionService = sessionService;
        this.http = http;
        this.restPath = restPath;
    }
    ProjectsService.prototype.listProjects = function () {
        return this.http.get("" + this.restPath.APP + this.restPath.listProyects);
    };
    ProjectsService.prototype.addProject = function (project) {
        return this.http.post("" + this.restPath.APP + this.restPath.addProyect, project);
    };
    ProjectsService.prototype.getProjectById = function (projectId) {
        return this.http.get("" + this.restPath.APP + this.restPath.projectById + projectId);
    };
    ProjectsService.prototype.postReunion = function (payload) {
        return this.http.post("" + this.restPath.APP + this.restPath.addActa, payload);
    };
    ProjectsService.prototype.listReunion = function (projectId) {
        return this.http.get("" + this.restPath.APP + this.restPath.listarReuniones + projectId);
    };
    ProjectsService.prototype.getAttendantList = function (actaId) {
        return this.http.get("" + this.restPath.APP + this.restPath.getAttendantList + actaId);
    };
    ProjectsService.prototype.getReunionById = function (actaId) {
        return this.http.get("" + this.restPath.APP + this.restPath.getMeetingById + actaId);
    };
    ProjectsService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_app_session_service_session_service__["a" /* SessionService */], __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["b" /* HttpClient */], __WEBPACK_IMPORTED_MODULE_3_app_share_constants_restPath__["a" /* restPath */]])
    ], ProjectsService);
    return ProjectsService;
}());



/***/ }),

/***/ "./src/app/session/service/session.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SessionService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_app_share_constants_restPath__ = __webpack_require__("./src/app/share/constants/restPath.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_common_http__ = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_Observable__ = __webpack_require__("./node_modules/rxjs/_esm5/Observable.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_router__ = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var SessionService = /** @class */ (function () {
    function SessionService(HttpClient, restPath, router) {
        this.HttpClient = HttpClient;
        this.restPath = restPath;
        this.router = router;
        this.setToken(localStorage['token']);
    }
    SessionService.prototype.logIn = function (user, pass) {
        this.setUsername(user);
        var param = { 'username': user, 'password': pass };
        return this.HttpClient.post("" + this.restPath.APP + this.restPath.logIn, param);
    };
    SessionService.prototype.logOut = function () {
        this.resetToken();
        this.router.navigate(['sign-on']);
    };
    SessionService.prototype.throwError = function (message) {
        throw __WEBPACK_IMPORTED_MODULE_3_rxjs_Observable__["a" /* Observable */].throw(message);
    };
    SessionService.prototype.setToken = function (token) {
        localStorage['token'] = token;
        this.token = localStorage['token'];
    };
    SessionService.prototype.setUsername = function (user) {
        localStorage['username'] = user;
        this.username = localStorage['username'];
    };
    SessionService.prototype.getUsername = function () {
        return this.username !== undefined ? this.username : localStorage['username'];
    };
    SessionService.prototype.resetToken = function () {
        delete localStorage['token'];
        this.token = undefined;
    };
    SessionService.prototype.getToken = function () {
        return this.token;
    };
    SessionService.prototype.getUserProfile = function () {
        return this.HttpClient.get("" + this.restPath.APP + this.restPath.getUser + this.getUsername());
    };
    SessionService.prototype.isAuthenticate = function () {
        return this.getToken() != undefined;
    };
    SessionService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__angular_common_http__["b" /* HttpClient */], __WEBPACK_IMPORTED_MODULE_1_app_share_constants_restPath__["a" /* restPath */], __WEBPACK_IMPORTED_MODULE_4__angular_router__["b" /* Router */]])
    ], SessionService);
    return SessionService;
}());



/***/ }),

/***/ "./src/app/session/sign-in/sign-in.component.html":
/***/ (function(module, exports) {

module.exports = "<p>\r\n  sign-in works!\r\n</p>\r\n"

/***/ }),

/***/ "./src/app/session/sign-in/sign-in.component.scss":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/session/sign-in/sign-in.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SignInComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var SignInComponent = /** @class */ (function () {
    function SignInComponent() {
    }
    SignInComponent.prototype.ngOnInit = function () {
    };
    SignInComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-sign-in',
            template: __webpack_require__("./src/app/session/sign-in/sign-in.component.html"),
            styles: [__webpack_require__("./src/app/session/sign-in/sign-in.component.scss")]
        }),
        __metadata("design:paramtypes", [])
    ], SignInComponent);
    return SignInComponent;
}());



/***/ }),

/***/ "./src/app/session/sign-on/sign-on.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container\" style=\"margin: 0;\">\r\n  <div class=\"row background\">\r\n    <div class=\"col-md-12\">\r\n      <img src=\"../../../assets/img/logos/meetingviewer-logo-lg.png\" class=\"meeting-logo\" alt=\"\">\r\n    </div>\r\n      <form action=\"\" [formGroup]=\"loginForm\" (ngSubmit)=\"onSubmit()\">\r\n        <div class=\"login-form\">\r\n          <div class=\"row login-form__login-inputs\">\r\n            <div class=\"col-md-12\">\r\n                <mat-icon svgIcon=\"email\"></mat-icon>\r\n                <mat-form-field>\r\n                  <input matInput placeholder=\"Correo Electronico\" type=\"email\" [(ngModel)]=\"User.userName\" formControlName=\"userName\">\r\n                </mat-form-field>\r\n            </div>\r\n            <div class=\"col-md-12\">\r\n              <mat-icon svgIcon=\"password\"></mat-icon>\r\n              <mat-form-field class=\"\">\r\n                <input matInput placeholder=\"Contraseña\" type=\"password\" [(ngModel)]=\"User.userPass\" formControlName=\"userPass\">\r\n              </mat-form-field>\r\n            </div>\r\n            <div class=\"col-md-12\">\r\n              <button mat-button type=\"submit\" [disabled]=\"!loginForm.valid\">Entrar</button>\r\n            </div>\r\n          </div>\r\n        </div>\r\n      </form>\r\n  </div>\r\n</div>"

/***/ }),

/***/ "./src/app/session/sign-on/sign-on.component.scss":
/***/ (function(module, exports) {

module.exports = ".login-form {\n  margin: 0 auto;\n  position: fixed;\n  -webkit-box-align: center;\n      -ms-flex-align: center;\n          align-items: center;\n  -webkit-box-shadow: 1px 2px 4px rgba(0, 0, 0, 0.5);\n          box-shadow: 1px 2px 4px rgba(0, 0, 0, 0.5);\n  border-radius: 5px;\n  top: 18em;\n  left: 30%;\n  background-color: #FFFFFF;\n  display: inline-block;\n  width: 40%;\n  z-index: 1000;\n  padding: 2em 1em 2em; }\n  .login-form__welcome-message {\n    text-align: center;\n    margin-top: 10%; }\n  .login-form__login-inputs {\n    width: 100%;\n    float: left;\n    padding: 1rem; }\n  .login-form mat-form-field {\n    width: 80%; }\n  .login-form mat-icon {\n    margin: 1em; }\n  .login-form button {\n    margin-left: 33%;\n    width: 30%;\n    -webkit-box-shadow: 1px 2px 4px rgba(0, 0, 0, 0.5);\n            box-shadow: 1px 2px 4px rgba(0, 0, 0, 0.5);\n    border-radius: 5px;\n    color: black; }\n  .login-form button:disabled {\n    color: gray; }\n  .meeting-logo {\n  display: block;\n  margin: 0 auto; }\n  .background {\n  position: fixed;\n  background-color: #19A0C4;\n  width: 100%;\n  height: 100%;\n  top: 0;\n  bottom: 0; }\n"

/***/ }),

/***/ "./src/app/session/sign-on/sign-on.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SignOnComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_app_session_service_session_service__ = __webpack_require__("./src/app/session/service/session.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_forms__ = __webpack_require__("./node_modules/@angular/forms/esm5/forms.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_app_models_user__ = __webpack_require__("./src/app/models/user.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_router__ = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var SignOnComponent = /** @class */ (function () {
    function SignOnComponent(SessionService, User, fb, route) {
        this.SessionService = SessionService;
        this.User = User;
        this.fb = fb;
        this.route = route;
        this.createLoginForm();
        this.User.userName = "ohidalgoleal@gmail.com";
        this.User.userPass = "dinero123";
    }
    SignOnComponent.prototype.createLoginForm = function () {
        this.loginForm = this.fb.group({
            userName: [this.User.userName, __WEBPACK_IMPORTED_MODULE_2__angular_forms__["i" /* Validators */].required],
            userPass: [this.User.userPass, __WEBPACK_IMPORTED_MODULE_2__angular_forms__["i" /* Validators */].required]
        });
    };
    SignOnComponent.prototype.ngOnInit = function () {
    };
    SignOnComponent.prototype.logIn = function () {
        var _this = this;
        this.SessionService.logIn(this.User.userName, this.User.userPass).subscribe(function (response) {
            response['token'] ? _this.token = response['token'] : _this.SessionService.throwError('We did not get a token');
            if (_this.token != undefined) {
                _this.SessionService.setToken(_this.token);
                _this.route.navigate(['project-list']);
            }
        }, function (err) {
            console.log(err);
        });
    };
    SignOnComponent.prototype.onSubmit = function () {
        this.logIn();
    };
    SignOnComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-sign-on',
            template: __webpack_require__("./src/app/session/sign-on/sign-on.component.html"),
            styles: [__webpack_require__("./src/app/session/sign-on/sign-on.component.scss")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_app_session_service_session_service__["a" /* SessionService */], __WEBPACK_IMPORTED_MODULE_3_app_models_user__["a" /* User */], __WEBPACK_IMPORTED_MODULE_2__angular_forms__["b" /* FormBuilder */], __WEBPACK_IMPORTED_MODULE_4__angular_router__["b" /* Router */]])
    ], SignOnComponent);
    return SignOnComponent;
}());



/***/ }),

/***/ "./src/app/session/toolbar/session.component.html":
/***/ (function(module, exports) {

module.exports = "<mat-toolbar>\r\n  <mat-toolbar-row>\r\n    <div class=\"toolbarContainer\">\r\n      <div class=\"toolbarContainer-session-options\">\r\n        <img src=\"../../../assets/img/logos/meetingviewer-logo-4.png\" alt=\"\">\r\n        <div class=\"toolbarContainer-session-options-username\">\r\n          <p>Hola, {{userName}} |</p>\r\n          <a (click)=\"closeSession()\">Cerrar Sesion</a>\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </mat-toolbar-row>\r\n</mat-toolbar>"

/***/ }),

/***/ "./src/app/session/toolbar/session.component.scss":
/***/ (function(module, exports) {

module.exports = "mat-toolbar {\n  background-color: #21B3D8;\n  color: #FFFFFF;\n  position: relative; }\n  mat-toolbar .toolbarContainer img {\n    display: inline-block; }\n  mat-toolbar .toolbarContainer-session-options p, mat-toolbar .toolbarContainer-session-options a, mat-toolbar .toolbarContainer-session-options img {\n    display: inline-block; }\n  mat-toolbar .toolbarContainer-session-options-username {\n    font-family: Helvetica Neue;\n    font-size: 13px;\n    position: absolute;\n    top: 0px;\n    right: 0px;\n    padding: 1em 1em; }\n  mat-toolbar .toolbarContainer-session-options-username p {\n      font-weight: 700; }\n  mat-toolbar .toolbarContainer-session-options-username a {\n      font-weight: 400;\n      cursor: pointer; }\n"

/***/ }),

/***/ "./src/app/session/toolbar/session.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SessionComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_app_session_service_session_service__ = __webpack_require__("./src/app/session/service/session.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var SessionComponent = /** @class */ (function () {
    function SessionComponent(sessionService) {
        this.sessionService = sessionService;
    }
    SessionComponent.prototype.ngOnInit = function () {
        this.getUserData();
    };
    SessionComponent.prototype.getUserData = function () {
        var _this = this;
        this.sessionService.getUserProfile().subscribe(function (response) {
            _this.userName = response['nombre'] + " " + response['apellido'];
        }, function (err) {
            console.log(err);
        });
    };
    SessionComponent.prototype.closeSession = function () {
        this.sessionService.logOut();
    };
    SessionComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-session',
            template: __webpack_require__("./src/app/session/toolbar/session.component.html"),
            styles: [__webpack_require__("./src/app/session/toolbar/session.component.scss")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_app_session_service_session_service__["a" /* SessionService */]])
    ], SessionComponent);
    return SessionComponent;
}());



/***/ }),

/***/ "./src/app/share/constants/restPath.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return restPath; });
var restPath = /** @class */ (function () {
    function restPath() {
        this.APP = '';
        //public APP: string = 'https://dminutezuul.herokuapp.com/api/dminutems';
        this.logIn = '/token/generate-token';
        this.listProyects = '/proyecto/listarProyectoUsuario';
        this.listUsers = '/usuario/listaUsuarios';
        this.addProyect = '/proyecto/nuevoProyecto';
        this.addActa = '/acta/guardarActa';
        this.projectById = '/proyecto/proyectoid/';
        this.guardarReunion = '/acta/guardarActa';
        this.listarReuniones = '/acta/listarActaProyecto/';
        this.getUser = '/usuario/user?username=';
        this.getAttendantList = '/acta/getUsuariosActa/';
        this.getMeetingById = '/acta/getActa/';
        this.usuarioGuardar = '/token/usuarioGuardar';
    }
    return restPath;
}());



/***/ }),

/***/ "./src/app/share/guards/authenticate-guard.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return authGuard; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_app_session_service_session_service__ = __webpack_require__("./src/app/session/service/session.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var authGuard = /** @class */ (function () {
    function authGuard(sessionService) {
        this.sessionService = sessionService;
    }
    authGuard.prototype.canActivate = function () {
        return this.sessionService.isAuthenticate();
    };
    authGuard = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_app_session_service_session_service__["a" /* SessionService */]])
    ], authGuard);
    return authGuard;
}());



/***/ }),

/***/ "./src/app/share/spinner/spinner.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"overlay\" [class.loader-hidden]=\"!show\">\r\n  <mat-spinner class=\"loading-spinner\">\r\n  </mat-spinner>\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/share/spinner/spinner.component.scss":
/***/ (function(module, exports) {

module.exports = ".overlay {\n  display: block;\n  position: fixed;\n  opacity: 0.5;\n  background: rgba(0, 0, 0, 0.5);\n  width: 100%;\n  height: 100%;\n  top: 0;\n  z-index: 1000;\n  bottom: 0; }\n\n.loader-hidden {\n  display: none; }\n\n.loading-spinner {\n  position: fixed;\n  top: 50%;\n  right: 50%; }\n"

/***/ }),

/***/ "./src/app/share/spinner/spinner.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SpinnerComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_app_share_spinner_spinner_service__ = __webpack_require__("./src/app/share/spinner/spinner.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_cdk_overlay__ = __webpack_require__("./node_modules/@angular/cdk/esm5/overlay.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_cdk_portal__ = __webpack_require__("./node_modules/@angular/cdk/esm5/portal.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var SpinnerComponent = /** @class */ (function () {
    function SpinnerComponent(loaderService, overlay) {
        this.loaderService = loaderService;
        this.overlay = overlay;
        this.show = false;
        this.overlayRef = this.overlay.create({
            height: '100%',
            width: '100%',
        });
        this.userProfilePortal = new __WEBPACK_IMPORTED_MODULE_3__angular_cdk_portal__["d" /* ComponentPortal */](SpinnerComponent_1);
    }
    SpinnerComponent_1 = SpinnerComponent;
    SpinnerComponent.prototype.openSpinner = function () {
        this.overlayRef.hasAttached() ? this.overlayRef.attach(this.userProfilePortal) : undefined;
    };
    SpinnerComponent.prototype.detachSpinner = function () {
        this.overlayRef.detach();
    };
    SpinnerComponent.prototype.ngAfterContentChecked = function () {
        var _this = this;
        this.subscription = this.loaderService.loaderState.subscribe(function (state) {
            if (state['show'] != undefined && _this.show !== state['show']) {
                _this.show = state.show;
                setTimeout(function () {
                    _this.show ? _this.openSpinner() : _this.detachSpinner();
                }, 0);
            }
        });
    };
    SpinnerComponent.prototype.ngOnDestroy = function () {
        this.subscription.unsubscribe();
    };
    SpinnerComponent = SpinnerComponent_1 = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-spinner',
            template: __webpack_require__("./src/app/share/spinner/spinner.component.html"),
            styles: [__webpack_require__("./src/app/share/spinner/spinner.component.scss")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_app_share_spinner_spinner_service__["a" /* SpinnerService */], __WEBPACK_IMPORTED_MODULE_2__angular_cdk_overlay__["c" /* Overlay */]])
    ], SpinnerComponent);
    return SpinnerComponent;
    var SpinnerComponent_1;
}());



/***/ }),

/***/ "./src/app/share/spinner/spinner.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SpinnerService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_rxjs_BehaviorSubject__ = __webpack_require__("./node_modules/rxjs/_esm5/BehaviorSubject.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var SpinnerService = /** @class */ (function () {
    function SpinnerService() {
        this.loaderSubject = new __WEBPACK_IMPORTED_MODULE_1_rxjs_BehaviorSubject__["a" /* BehaviorSubject */]({ show: false });
        this.loaderState = this.loaderSubject.asObservable();
    }
    SpinnerService.prototype.show = function () {
        this.loaderSubject.next({ show: true });
    };
    SpinnerService.prototype.hide = function () {
        this.loaderSubject.next({ show: false });
    };
    SpinnerService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
        __metadata("design:paramtypes", [])
    ], SpinnerService);
    return SpinnerService;
}());



/***/ }),

/***/ "./src/app/user/create-user/create-user.component.html":
/***/ (function(module, exports) {

module.exports = "\r\n  <div class=\"container\" >\r\n    <form [formGroup]=\"addUserForm\" (ngSubmit)=\"postUsuario()\">\r\n      <div class=\"row\">\r\n        <div class=\"col-sm-12\">\r\n          <h2>Agregar Usuario</h2>\r\n        </div>\r\n        <div class=\"col-sm-12\">\r\n            <mat-form-field>\r\n                <input matInput placeholder=\"Nombre\" [(ngModel)]=\"user.nombre\"  formControlName=\"nombre\" type=\"text\">\r\n            </mat-form-field>\r\n            <mat-form-field>\r\n                <input matInput placeholder=\"Apellido\" [(ngModel)]=\"user.apellido\" formControlName=\"apellido\" type=\"text\">\r\n            </mat-form-field>\r\n        </div>\r\n        <div class=\"col-sm-12\">\r\n            <mat-form-field>\r\n                <input matInput placeholder=\"Nombre de Usuario\" [(ngModel)]=\"user.username\" formControlName=\"username\" type=\"text\">\r\n            </mat-form-field>\r\n        </div>\r\n        <div class=\"col-sm-12\">\r\n            <mat-form-field>\r\n                <input matInput placeholder=\"Contraseña\" [(ngModel)]=\"user.password\" formControlName=\"password\" type=\"password\">\r\n            </mat-form-field>\r\n        </div>\r\n        <div class=\"col-sm-12\">\r\n            <button mat-raised-button type=\"submit\">Agregar Usuario</button>\r\n        </div>\r\n      </div>\r\n    </form>\r\n  </div>\r\n\r\n\r\n<!-- \"username\": \"juan@gmail.como\",\r\n    \"nombre\": \"juan\",\r\n    \"apellido\": \"juan\",\r\n    \"password\": \"dinero123\" -->"

/***/ }),

/***/ "./src/app/user/create-user/create-user.component.scss":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/user/create-user/create-user.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CreateUserComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_app_models_usuario__ = __webpack_require__("./src/app/models/usuario.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_forms__ = __webpack_require__("./node_modules/@angular/forms/esm5/forms.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_app_user_service_users_service__ = __webpack_require__("./src/app/user/service/users.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_material__ = __webpack_require__("./node_modules/@angular/material/esm5/material.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var CreateUserComponent = /** @class */ (function () {
    function CreateUserComponent(fb, user, userService, dialogRef) {
        this.fb = fb;
        this.user = user;
        this.userService = userService;
        this.dialogRef = dialogRef;
    }
    CreateUserComponent.prototype.ngOnInit = function () {
        this.createUserForm();
    };
    CreateUserComponent.prototype.createUserForm = function () {
        this.addUserForm = this.fb.group({
            username: [this.user.username, __WEBPACK_IMPORTED_MODULE_2__angular_forms__["i" /* Validators */].required],
            nombre: [this.user.nombre, __WEBPACK_IMPORTED_MODULE_2__angular_forms__["i" /* Validators */].required],
            apellido: [this.user.apellido, __WEBPACK_IMPORTED_MODULE_2__angular_forms__["i" /* Validators */].required],
            password: [this.user.password, __WEBPACK_IMPORTED_MODULE_2__angular_forms__["i" /* Validators */].required]
        });
    };
    CreateUserComponent.prototype.closeDialog = function () {
        this.dialogRef.close();
    };
    CreateUserComponent.prototype.postUsuario = function () {
        var _this = this;
        if (this.addUserForm.valid) {
            this.userService.postUser(this.user)
                .subscribe(function (data) {
                _this.closeDialog();
            }, function (error) {
                console.log(error);
            });
        }
    };
    CreateUserComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-create-user',
            template: __webpack_require__("./src/app/user/create-user/create-user.component.html"),
            styles: [__webpack_require__("./src/app/user/create-user/create-user.component.scss")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__angular_forms__["b" /* FormBuilder */], __WEBPACK_IMPORTED_MODULE_1_app_models_usuario__["a" /* Usuario */], __WEBPACK_IMPORTED_MODULE_3_app_user_service_users_service__["a" /* UsersService */], __WEBPACK_IMPORTED_MODULE_4__angular_material__["e" /* MatDialogRef */]])
    ], CreateUserComponent);
    return CreateUserComponent;
}());



/***/ }),

/***/ "./src/app/user/service/users.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return UsersService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_app_share_constants_restPath__ = __webpack_require__("./src/app/share/constants/restPath.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_common_http__ = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var UsersService = /** @class */ (function () {
    function UsersService(HttpClient, restPath) {
        this.HttpClient = HttpClient;
        this.restPath = restPath;
    }
    UsersService.prototype.getListUsers = function () {
        return this.HttpClient.get("" + this.restPath.APP + this.restPath.listUsers);
    };
    UsersService.prototype.postUser = function (user) {
        return this.HttpClient.post("" + this.restPath.APP + this.restPath.usuarioGuardar, user);
    };
    UsersService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__angular_common_http__["b" /* HttpClient */], __WEBPACK_IMPORTED_MODULE_1_app_share_constants_restPath__["a" /* restPath */]])
    ], UsersService);
    return UsersService;
}());



/***/ }),

/***/ "./src/app/user/users-list/users-list.component.html":
/***/ (function(module, exports) {

module.exports = "\r\n  <form  [formGroup]=\"addUserForm\">\r\n    <div class=\"row\">\r\n      <div class=\"col-md-6 selectContainer\">\r\n        <mat-form-field>\r\n          <mat-select placeholder=\"Miembros del Equipo\" [(ngModel)]=\"selectedMember\" formControlName=\"selectedMember\">\r\n            <mat-option *ngFor=\"let user of listOfUsers\" [value]=\"user\">\r\n              {{ user.fullName }}\r\n            </mat-option>\r\n          </mat-select>\r\n        </mat-form-field>\r\n      </div>\r\n      <div class=\"col-md-6\">\r\n        <mat-list *ngIf=\"listOfSelectedUsers.length > 0\">\r\n          <h3 mat-subheader>Miembros</h3>\r\n          <mat-list-item *ngFor=\"let member of listOfSelectedUsers\">\r\n            <h4 mat-line>{{ member.nombre }}</h4>\r\n            <p mat-line> {{ member.username }} </p>\r\n            <button mat-raised-button type=\"button\" class=\"deleteMember\" (click)=\"deleteMember(member)\">\r\n              <mat-icon svgIcon=\"delete\"></mat-icon>\r\n            </button>\r\n          </mat-list-item>\r\n        </mat-list>\r\n      </div>\r\n      <div class=\"col-md-6\">\r\n        <button mat-raised-button type=\"button\" (click)=\"addMember()\">Agregar Miembro</button>\r\n      </div>\r\n      <div class=\"col-md-6\">\r\n        <button mat-raised-button type=\"button\" (click)=\"submitList()\">Editar Lista</button>\r\n      </div>\r\n    </div>\r\n  </form>"

/***/ }),

/***/ "./src/app/user/users-list/users-list.component.scss":
/***/ (function(module, exports) {

module.exports = ".selectContainer {\n  display: block;\n  margin: 5em auto; }\n"

/***/ }),

/***/ "./src/app/user/users-list/users-list.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return UsersListComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_app_user_service_users_service__ = __webpack_require__("./src/app/user/service/users.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_forms__ = __webpack_require__("./node_modules/@angular/forms/esm5/forms.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var UsersListComponent = /** @class */ (function () {
    function UsersListComponent(UsersService, fb) {
        this.UsersService = UsersService;
        this.fb = fb;
        this.onSubmit = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["x" /* EventEmitter */]();
    }
    UsersListComponent.prototype.ngOnInit = function () {
        this.createListForm();
        this.listOfSelectedUsers = [];
        this.getListOfUsers();
    };
    UsersListComponent.prototype.getListOfUsers = function () {
        var _this = this;
        setTimeout(function () {
            _this.UsersService.getListUsers().subscribe(function (response) {
                _this.listOfUsers = response.map(function (cv) {
                    return Object.assign({ fullName: cv['nombre'] + " " + cv['apellido'] }, cv);
                });
            }, function (err) {
                console.log(err);
            });
        }, 0);
    };
    UsersListComponent.prototype.createListForm = function () {
        this.listOfUsersForm = this.fb.group({
            selectedMember: [this.selectedMember],
            listOfSelectedUsers: [this.listOfSelectedUsers]
        });
    };
    UsersListComponent.prototype.submitList = function () {
        this.onSubmit.emit(true);
    };
    UsersListComponent.prototype.addMember = function () {
        if (this.selectedMember != undefined && !this.listOfSelectedUsers.includes(this.selectedMember)) {
            this.listOfSelectedUsers.push(this.selectedMember);
            var index = this.listOfUsers.indexOf(this.selectedMember);
            this.listOfUsers.splice(index, 1);
            this.selectedMember = undefined;
        }
    };
    UsersListComponent.prototype.deleteMember = function (miembro) {
        var index = this.listOfSelectedUsers.indexOf(miembro);
        index > -1 ? this.listOfSelectedUsers.splice(index, 1) : console.log('Member Not Found');
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["R" /* Output */])(),
        __metadata("design:type", Object)
    ], UsersListComponent.prototype, "onSubmit", void 0);
    UsersListComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-users-list',
            template: __webpack_require__("./src/app/user/users-list/users-list.component.html"),
            styles: [__webpack_require__("./src/app/user/users-list/users-list.component.scss")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_app_user_service_users_service__["a" /* UsersService */], __WEBPACK_IMPORTED_MODULE_2__angular_forms__["b" /* FormBuilder */]])
    ], UsersListComponent);
    return UsersListComponent;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return environment; });
// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.
var environment = {
    production: false
};


/***/ }),

/***/ "./src/main.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__ = __webpack_require__("./node_modules/@angular/platform-browser-dynamic/esm5/platform-browser-dynamic.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_app_module__ = __webpack_require__("./src/app/app.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("./src/environments/environment.ts");




if (__WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].production) {
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_17" /* enableProdMode */])();
}
Object(__WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_2__app_app_module__["a" /* AppModule */])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ 0:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__("./src/main.ts");


/***/ })

},[0]);
//# sourceMappingURL=main.bundle.js.map