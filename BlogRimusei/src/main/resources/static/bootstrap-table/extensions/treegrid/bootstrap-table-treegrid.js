/**
  * bootstrap-table - An extended table to integration with some of the most widely used CSS frameworks. (Supports Bootstrap, Semantic UI, Bulma, Material Design, Foundation)
  *
  * @version v1.21.2
  * @homepage https://bootstrap-table.com
  * @author wenzhixin <wenzhixin2010@gmail.com> (http://wenzhixin.net.cn/)
  * @license MIT
  */

!function(t, e) {
    "object" == typeof exports && "undefined" != typeof module ? e(require("jquery")) : "function" == typeof define && define.amd ? define(["jquery"], e) : e((t = "undefined" != typeof globalThis ? globalThis : t || self).jQuery)
}(this, (function(t) {
    "use strict";
    function e(t) {
        return t && "object" == typeof t && "default"in t ? t : {
            default: t
        }
    }
    var r = e(t);
    function n(t, e) {
        if (!(t instanceof e))
            throw new TypeError("Cannot call a class as a function")
    }
    function o(t, e) {
        for (var r = 0; r < e.length; r++) {
            var n = e[r];
            n.enumerable = n.enumerable || !1,
            n.configurable = !0,
            "value"in n && (n.writable = !0),
            Object.defineProperty(t, n.key, n)
        }
    }
    function i(t) {
        return i = Object.setPrototypeOf ? Object.getPrototypeOf.bind() : function(t) {
            return t.__proto__ || Object.getPrototypeOf(t)
        }
        ,
        i(t)
    }
    function u(t, e) {
        return u = Object.setPrototypeOf ? Object.setPrototypeOf.bind() : function(t, e) {
            return t.__proto__ = e,
            t
        }
        ,
        u(t, e)
    }
    function c(t, e) {
        if (e && ("object" == typeof e || "function" == typeof e))
            return e;
        if (void 0 !== e)
            throw new TypeError("Derived constructors may only return object or undefined");
        return function(t) {
            if (void 0 === t)
                throw new ReferenceError("this hasn't been initialised - super() hasn't been called");
            return t
        }(t)
    }
    function a(t) {
        var e = function() {
            if ("undefined" == typeof Reflect || !Reflect.construct)
                return !1;
            if (Reflect.construct.sham)
                return !1;
            if ("function" == typeof Proxy)
                return !0;
            try {
                return Boolean.prototype.valueOf.call(Reflect.construct(Boolean, [], (function() {}
                ))),
                !0
            } catch (t) {
                return !1
            }
        }();
        return function() {
            var r, n = i(t);
            if (e) {
                var o = i(this).constructor;
                r = Reflect.construct(n, arguments, o)
            } else
                r = n.apply(this, arguments);
            return c(this, r)
        }
    }
    function f(t, e) {
        for (; !Object.prototype.hasOwnProperty.call(t, e) && null !== (t = i(t)); )
            ;
        return t
    }
    function l() {
        return l = "undefined" != typeof Reflect && Reflect.get ? Reflect.get.bind() : function(t, e, r) {
            var n = f(t, e);
            if (n) {
                var o = Object.getOwnPropertyDescriptor(n, e);
                return o.get ? o.get.call(arguments.length < 3 ? t : r) : o.value
            }
        }
        ,
        l.apply(this, arguments)
    }
    function s(t, e) {
        (null == e || e > t.length) && (e = t.length);
        for (var r = 0, n = new Array(e); r < e; r++)
            n[r] = t[r];
        return n
    }
    function p(t, e) {
        var r = "undefined" != typeof Symbol && t[Symbol.iterator] || t["@@iterator"];
        if (!r) {
            if (Array.isArray(t) || (r = function(t, e) {
                if (t) {
                    if ("string" == typeof t)
                        return s(t, e);
                    var r = Object.prototype.toString.call(t).slice(8, -1);
                    return "Object" === r && t.constructor && (r = t.constructor.name),
                    "Map" === r || "Set" === r ? Array.from(t) : "Arguments" === r || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(r) ? s(t, e) : void 0
                }
            }(t)) || e && t && "number" == typeof t.length) {
                r && (t = r);
                var n = 0
                  , o = function() {};
                return {
                    s: o,
                    n: function() {
                        return n >= t.length ? {
                            done: !0
                        } : {
                            done: !1,
                            value: t[n++]
                        }
                    },
                    e: function(t) {
                        throw t
                    },
                    f: o
                }
            }
            throw new TypeError("Invalid attempt to iterate non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")
        }
        var i, u = !0, c = !1;
        return {
            s: function() {
                r = r.call(t)
            },
            n: function() {
                var t = r.next();
                return u = t.done,
                t
            },
            e: function(t) {
                c = !0,
                i = t
            },
            f: function() {
                try {
                    u || null == r.return || r.return()
                } finally {
                    if (c)
                        throw i
                }
            }
        }
    }
    var y = "undefined" != typeof globalThis ? globalThis : "undefined" != typeof window ? window : "undefined" != typeof global ? global : "undefined" != typeof self ? self : {}
      , d = function(t) {
        return t && t.Math == Math && t
    }
      , v = d("object" == typeof globalThis && globalThis) || d("object" == typeof window && window) || d("object" == typeof self && self) || d("object" == typeof y && y) || function() {
        return this
    }() || Function("return this")()
      , h = {}
      , b = function(t) {
        try {
            return !!t()
        } catch (t) {
            return !0
        }
    }
      , g = !b((function() {
        return 7 != Object.defineProperty({}, 1, {
            get: function() {
                return 7
            }
        })[1]
    }
    ))
      , m = !b((function() {
        var t = function() {}
        .bind();
        return "function" != typeof t || t.hasOwnProperty("prototype")
    }
    ))
      , w = m
      , S = Function.prototype.call
      , j = w ? S.bind(S) : function() {
        return S.apply(S, arguments)
    }
      , O = {}
      , P = {}.propertyIsEnumerable
      , E = Object.getOwnPropertyDescriptor
      , T = E && !P.call({
        1: 2
    }, 1);
    O.f = T ? function(t) {
        var e = E(this, t);
        return !!e && e.enumerable
    }
    : P;
    var A, I, x = function(t, e) {
        return {
            enumerable: !(1 & t),
            configurable: !(2 & t),
            writable: !(4 & t),
            value: e
        }
    }, F = m, _ = Function.prototype, R = _.call, k = F && _.bind.bind(R, R), M = function(t) {
        return F ? k(t) : function() {
            return R.apply(t, arguments)
        }
    }, C = M, D = C({}.toString), L = C("".slice), B = function(t) {
        return L(D(t), 8, -1)
    }, z = B, N = M, G = function(t) {
        if ("Function" === z(t))
            return N(t)
    }, H = b, q = B, U = Object, W = G("".split), $ = H((function() {
        return !U("z").propertyIsEnumerable(0)
    }
    )) ? function(t) {
        return "String" == q(t) ? W(t, "") : U(t)
    }
    : U, K = function(t) {
        return null == t
    }, Q = K, V = TypeError, X = function(t) {
        if (Q(t))
            throw V("Can't call method on " + t);
        return t
    }, Y = $, J = X, Z = function(t) {
        return Y(J(t))
    }, tt = "object" == typeof document && document.all, et = {
        all: tt,
        IS_HTMLDDA: void 0 === tt && void 0 !== tt
    }, rt = et.all, nt = et.IS_HTMLDDA ? function(t) {
        return "function" == typeof t || t === rt
    }
    : function(t) {
        return "function" == typeof t
    }
    , ot = nt, it = et.all, ut = et.IS_HTMLDDA ? function(t) {
        return "object" == typeof t ? null !== t : ot(t) || t === it
    }
    : function(t) {
        return "object" == typeof t ? null !== t : ot(t)
    }
    , ct = v, at = nt, ft = function(t) {
        return at(t) ? t : void 0
    }, lt = function(t, e) {
        return arguments.length < 2 ? ft(ct[t]) : ct[t] && ct[t][e]
    }, st = G({}.isPrototypeOf), pt = v, yt = lt("navigator", "userAgent") || "", dt = pt.process, vt = pt.Deno, ht = dt && dt.versions || vt && vt.version, bt = ht && ht.v8;
    bt && (I = (A = bt.split("."))[0] > 0 && A[0] < 4 ? 1 : +(A[0] + A[1])),
    !I && yt && (!(A = yt.match(/Edge\/(\d+)/)) || A[1] >= 74) && (A = yt.match(/Chrome\/(\d+)/)) && (I = +A[1]);
    var gt = I
      , mt = gt
      , wt = b
      , St = !!Object.getOwnPropertySymbols && !wt((function() {
        var t = Symbol();
        return !String(t) || !(Object(t)instanceof Symbol) || !Symbol.sham && mt && mt < 41
    }
    ))
      , jt = St && !Symbol.sham && "symbol" == typeof Symbol.iterator
      , Ot = lt
      , Pt = nt
      , Et = st
      , Tt = Object
      , At = jt ? function(t) {
        return "symbol" == typeof t
    }
    : function(t) {
        var e = Ot("Symbol");
        return Pt(e) && Et(e.prototype, Tt(t))
    }
      , It = String
      , xt = nt
      , Ft = function(t) {
        try {
            return It(t)
        } catch (t) {
            return "Object"
        }
    }
      , _t = TypeError
      , Rt = function(t) {
        if (xt(t))
            return t;
        throw _t(Ft(t) + " is not a function")
    }
      , kt = Rt
      , Mt = K
      , Ct = j
      , Dt = nt
      , Lt = ut
      , Bt = TypeError
      , zt = {
        exports: {}
    }
      , Nt = v
      , Gt = Object.defineProperty
      , Ht = function(t, e) {
        try {
            Gt(Nt, t, {
                value: e,
                configurable: !0,
                writable: !0
            })
        } catch (r) {
            Nt[t] = e
        }
        return e
    }
      , qt = Ht
      , Ut = "__core-js_shared__"
      , Wt = v[Ut] || qt(Ut, {})
      , $t = Wt;
    (zt.exports = function(t, e) {
        return $t[t] || ($t[t] = void 0 !== e ? e : {})
    }
    )("versions", []).push({
        version: "3.25.5",
        mode: "global",
        copyright: "© 2014-2022 Denis Pushkarev (zloirock.ru)",
        license: "https://github.com/zloirock/core-js/blob/v3.25.5/LICENSE",
        source: "https://github.com/zloirock/core-js"
    });
    var Kt = X
      , Qt = Object
      , Vt = function(t) {
        return Qt(Kt(t))
    }
      , Xt = Vt
      , Yt = G({}.hasOwnProperty)
      , Jt = Object.hasOwn || function(t, e) {
        return Yt(Xt(t), e)
    }
      , Zt = G
      , te = 0
      , ee = Math.random()
      , re = Zt(1..toString)
      , ne = function(t) {
        return "Symbol(" + (void 0 === t ? "" : t) + ")_" + re(++te + ee, 36)
    }
      , oe = v
      , ie = zt.exports
      , ue = Jt
      , ce = ne
      , ae = St
      , fe = jt
      , le = ie("wks")
      , se = oe.Symbol
      , pe = se && se.for
      , ye = fe ? se : se && se.withoutSetter || ce
      , de = function(t) {
        if (!ue(le, t) || !ae && "string" != typeof le[t]) {
            var e = "Symbol." + t;
            ae && ue(se, t) ? le[t] = se[t] : le[t] = fe && pe ? pe(e) : ye(e)
        }
        return le[t]
    }
      , ve = j
      , he = ut
      , be = At
      , ge = function(t, e) {
        var r = t[e];
        return Mt(r) ? void 0 : kt(r)
    }
      , me = function(t, e) {
        var r, n;
        if ("string" === e && Dt(r = t.toString) && !Lt(n = Ct(r, t)))
            return n;
        if (Dt(r = t.valueOf) && !Lt(n = Ct(r, t)))
            return n;
        if ("string" !== e && Dt(r = t.toString) && !Lt(n = Ct(r, t)))
            return n;
        throw Bt("Can't convert object to primitive value")
    }
      , we = TypeError
      , Se = de("toPrimitive")
      , je = function(t, e) {
        if (!he(t) || be(t))
            return t;
        var r, n = ge(t, Se);
        if (n) {
            if (void 0 === e && (e = "default"),
            r = ve(n, t, e),
            !he(r) || be(r))
                return r;
            throw we("Can't convert object to primitive value")
        }
        return void 0 === e && (e = "number"),
        me(t, e)
    }
      , Oe = At
      , Pe = function(t) {
        var e = je(t, "string");
        return Oe(e) ? e : e + ""
    }
      , Ee = ut
      , Te = v.document
      , Ae = Ee(Te) && Ee(Te.createElement)
      , Ie = function(t) {
        return Ae ? Te.createElement(t) : {}
    }
      , xe = !g && !b((function() {
        return 7 != Object.defineProperty(Ie("div"), "a", {
            get: function() {
                return 7
            }
        }).a
    }
    ))
      , Fe = g
      , _e = j
      , Re = O
      , ke = x
      , Me = Z
      , Ce = Pe
      , De = Jt
      , Le = xe
      , Be = Object.getOwnPropertyDescriptor;
    h.f = Fe ? Be : function(t, e) {
        if (t = Me(t),
        e = Ce(e),
        Le)
            try {
                return Be(t, e)
            } catch (t) {}
        if (De(t, e))
            return ke(!_e(Re.f, t, e), t[e])
    }
    ;
    var ze = {}
      , Ne = g && b((function() {
        return 42 != Object.defineProperty((function() {}
        ), "prototype", {
            value: 42,
            writable: !1
        }).prototype
    }
    ))
      , Ge = ut
      , He = String
      , qe = TypeError
      , Ue = function(t) {
        if (Ge(t))
            return t;
        throw qe(He(t) + " is not an object")
    }
      , We = g
      , $e = xe
      , Ke = Ne
      , Qe = Ue
      , Ve = Pe
      , Xe = TypeError
      , Ye = Object.defineProperty
      , Je = Object.getOwnPropertyDescriptor
      , Ze = "enumerable"
      , tr = "configurable"
      , er = "writable";
    ze.f = We ? Ke ? function(t, e, r) {
        if (Qe(t),
        e = Ve(e),
        Qe(r),
        "function" == typeof t && "prototype" === e && "value"in r && er in r && !r.writable) {
            var n = Je(t, e);
            n && n.writable && (t[e] = r.value,
            r = {
                configurable: tr in r ? r.configurable : n.configurable,
                enumerable: Ze in r ? r.enumerable : n.enumerable,
                writable: !1
            })
        }
        return Ye(t, e, r)
    }
    : Ye : function(t, e, r) {
        if (Qe(t),
        e = Ve(e),
        Qe(r),
        $e)
            try {
                return Ye(t, e, r)
            } catch (t) {}
        if ("get"in r || "set"in r)
            throw Xe("Accessors not supported");
        return "value"in r && (t[e] = r.value),
        t
    }
    ;
    var rr = ze
      , nr = x
      , or = g ? function(t, e, r) {
        return rr.f(t, e, nr(1, r))
    }
    : function(t, e, r) {
        return t[e] = r,
        t
    }
      , ir = {
        exports: {}
    }
      , ur = g
      , cr = Jt
      , ar = Function.prototype
      , fr = ur && Object.getOwnPropertyDescriptor
      , lr = cr(ar, "name")
      , sr = {
        EXISTS: lr,
        PROPER: lr && "something" === function() {}
        .name,
        CONFIGURABLE: lr && (!ur || ur && fr(ar, "name").configurable)
    }
      , pr = nt
      , yr = Wt
      , dr = G(Function.toString);
    pr(yr.inspectSource) || (yr.inspectSource = function(t) {
        return dr(t)
    }
    );
    var vr, hr, br, gr = yr.inspectSource, mr = nt, wr = v.WeakMap, Sr = mr(wr) && /native code/.test(String(wr)), jr = zt.exports, Or = ne, Pr = jr("keys"), Er = {}, Tr = Sr, Ar = v, Ir = ut, xr = or, Fr = Jt, _r = Wt, Rr = function(t) {
        return Pr[t] || (Pr[t] = Or(t))
    }, kr = Er, Mr = "Object already initialized", Cr = Ar.TypeError, Dr = Ar.WeakMap;
    if (Tr || _r.state) {
        var Lr = _r.state || (_r.state = new Dr);
        Lr.get = Lr.get,
        Lr.has = Lr.has,
        Lr.set = Lr.set,
        vr = function(t, e) {
            if (Lr.has(t))
                throw Cr(Mr);
            return e.facade = t,
            Lr.set(t, e),
            e
        }
        ,
        hr = function(t) {
            return Lr.get(t) || {}
        }
        ,
        br = function(t) {
            return Lr.has(t)
        }
    } else {
        var Br = Rr("state");
        kr[Br] = !0,
        vr = function(t, e) {
            if (Fr(t, Br))
                throw Cr(Mr);
            return e.facade = t,
            xr(t, Br, e),
            e
        }
        ,
        hr = function(t) {
            return Fr(t, Br) ? t[Br] : {}
        }
        ,
        br = function(t) {
            return Fr(t, Br)
        }
    }
    var zr = {
        set: vr,
        get: hr,
        has: br,
        enforce: function(t) {
            return br(t) ? hr(t) : vr(t, {})
        },
        getterFor: function(t) {
            return function(e) {
                var r;
                if (!Ir(e) || (r = hr(e)).type !== t)
                    throw Cr("Incompatible receiver, " + t + " required");
                return r
            }
        }
    }
      , Nr = b
      , Gr = nt
      , Hr = Jt
      , qr = g
      , Ur = sr.CONFIGURABLE
      , Wr = gr
      , $r = zr.enforce
      , Kr = zr.get
      , Qr = Object.defineProperty
      , Vr = qr && !Nr((function() {
        return 8 !== Qr((function() {}
        ), "length", {
            value: 8
        }).length
    }
    ))
      , Xr = String(String).split("String")
      , Yr = ir.exports = function(t, e, r) {
        "Symbol(" === String(e).slice(0, 7) && (e = "[" + String(e).replace(/^Symbol\(([^)]*)\)/, "$1") + "]"),
        r && r.getter && (e = "get " + e),
        r && r.setter && (e = "set " + e),
        (!Hr(t, "name") || Ur && t.name !== e) && (qr ? Qr(t, "name", {
            value: e,
            configurable: !0
        }) : t.name = e),
        Vr && r && Hr(r, "arity") && t.length !== r.arity && Qr(t, "length", {
            value: r.arity
        });
        try {
            r && Hr(r, "constructor") && r.constructor ? qr && Qr(t, "prototype", {
                writable: !1
            }) : t.prototype && (t.prototype = void 0)
        } catch (t) {}
        var n = $r(t);
        return Hr(n, "source") || (n.source = Xr.join("string" == typeof e ? e : "")),
        t
    }
    ;
    Function.prototype.toString = Yr((function() {
        return Gr(this) && Kr(this).source || Wr(this)
    }
    ), "toString");
    var Jr = nt
      , Zr = ze
      , tn = ir.exports
      , en = Ht
      , rn = function(t, e, r, n) {
        n || (n = {});
        var o = n.enumerable
          , i = void 0 !== n.name ? n.name : e;
        if (Jr(r) && tn(r, i, n),
        n.global)
            o ? t[e] = r : en(e, r);
        else {
            try {
                n.unsafe ? t[e] && (o = !0) : delete t[e]
            } catch (t) {}
            o ? t[e] = r : Zr.f(t, e, {
                value: r,
                enumerable: !1,
                configurable: !n.nonConfigurable,
                writable: !n.nonWritable
            })
        }
        return t
    }
      , nn = {}
      , on = Math.ceil
      , un = Math.floor
      , cn = Math.trunc || function(t) {
        var e = +t;
        return (e > 0 ? un : on)(e)
    }
      , an = function(t) {
        var e = +t;
        return e != e || 0 === e ? 0 : cn(e)
    }
      , fn = an
      , ln = Math.max
      , sn = Math.min
      , pn = an
      , yn = Math.min
      , dn = function(t) {
        return t > 0 ? yn(pn(t), 9007199254740991) : 0
    }
      , vn = function(t) {
        return dn(t.length)
    }
      , hn = Z
      , bn = function(t, e) {
        var r = fn(t);
        return r < 0 ? ln(r + e, 0) : sn(r, e)
    }
      , gn = vn
      , mn = function(t) {
        return function(e, r, n) {
            var o, i = hn(e), u = gn(i), c = bn(n, u);
            if (t && r != r) {
                for (; u > c; )
                    if ((o = i[c++]) != o)
                        return !0
            } else
                for (; u > c; c++)
                    if ((t || c in i) && i[c] === r)
                        return t || c || 0;
            return !t && -1
        }
    }
      , wn = {
        includes: mn(!0),
        indexOf: mn(!1)
    }
      , Sn = Jt
      , jn = Z
      , On = wn.indexOf
      , Pn = Er
      , En = G([].push)
      , Tn = function(t, e) {
        var r, n = jn(t), o = 0, i = [];
        for (r in n)
            !Sn(Pn, r) && Sn(n, r) && En(i, r);
        for (; e.length > o; )
            Sn(n, r = e[o++]) && (~On(i, r) || En(i, r));
        return i
    }
      , An = ["constructor", "hasOwnProperty", "isPrototypeOf", "propertyIsEnumerable", "toLocaleString", "toString", "valueOf"].concat("length", "prototype");
    nn.f = Object.getOwnPropertyNames || function(t) {
        return Tn(t, An)
    }
    ;
    var In = {};
    In.f = Object.getOwnPropertySymbols;
    var xn = lt
      , Fn = nn
      , _n = In
      , Rn = Ue
      , kn = G([].concat)
      , Mn = xn("Reflect", "ownKeys") || function(t) {
        var e = Fn.f(Rn(t))
          , r = _n.f;
        return r ? kn(e, r(t)) : e
    }
      , Cn = Jt
      , Dn = Mn
      , Ln = h
      , Bn = ze
      , zn = b
      , Nn = nt
      , Gn = /#|\.prototype\./
      , Hn = function(t, e) {
        var r = Un[qn(t)];
        return r == $n || r != Wn && (Nn(e) ? zn(e) : !!e)
    }
      , qn = Hn.normalize = function(t) {
        return String(t).replace(Gn, ".").toLowerCase()
    }
      , Un = Hn.data = {}
      , Wn = Hn.NATIVE = "N"
      , $n = Hn.POLYFILL = "P"
      , Kn = Hn
      , Qn = v
      , Vn = h.f
      , Xn = or
      , Yn = rn
      , Jn = Ht
      , Zn = function(t, e, r) {
        for (var n = Dn(e), o = Bn.f, i = Ln.f, u = 0; u < n.length; u++) {
            var c = n[u];
            Cn(t, c) || r && Cn(r, c) || o(t, c, i(e, c))
        }
    }
      , to = Kn
      , eo = function(t, e) {
        var r, n, o, i, u, c = t.target, a = t.global, f = t.stat;
        if (r = a ? Qn : f ? Qn[c] || Jn(c, {}) : (Qn[c] || {}).prototype)
            for (n in e) {
                if (i = e[n],
                o = t.dontCallGetSet ? (u = Vn(r, n)) && u.value : r[n],
                !to(a ? n : c + (f ? "." : "#") + n, t.forced) && void 0 !== o) {
                    if (typeof i == typeof o)
                        continue;
                    Zn(i, o)
                }
                (t.sham || o && o.sham) && Xn(i, "sham", !0),
                Yn(r, n, i, t)
            }
    }
      , ro = B
      , no = Array.isArray || function(t) {
        return "Array" == ro(t)
    }
      , oo = TypeError
      , io = Pe
      , uo = ze
      , co = x
      , ao = {};
    ao[de("toStringTag")] = "z";
    var fo = "[object z]" === String(ao)
      , lo = fo
      , so = nt
      , po = B
      , yo = de("toStringTag")
      , vo = Object
      , ho = "Arguments" == po(function() {
        return arguments
    }())
      , bo = lo ? po : function(t) {
        var e, r, n;
        return void 0 === t ? "Undefined" : null === t ? "Null" : "string" == typeof (r = function(t, e) {
            try {
                return t[e]
            } catch (t) {}
        }(e = vo(t), yo)) ? r : ho ? po(e) : "Object" == (n = po(e)) && so(e.callee) ? "Arguments" : n
    }
      , go = G
      , mo = b
      , wo = nt
      , So = bo
      , jo = gr
      , Oo = function() {}
      , Po = []
      , Eo = lt("Reflect", "construct")
      , To = /^\s*(?:class|function)\b/
      , Ao = go(To.exec)
      , Io = !To.exec(Oo)
      , xo = function(t) {
        if (!wo(t))
            return !1;
        try {
            return Eo(Oo, Po, t),
            !0
        } catch (t) {
            return !1
        }
    }
      , Fo = function(t) {
        if (!wo(t))
            return !1;
        switch (So(t)) {
        case "AsyncFunction":
        case "GeneratorFunction":
        case "AsyncGeneratorFunction":
            return !1
        }
        try {
            return Io || !!Ao(To, jo(t))
        } catch (t) {
            return !0
        }
    };
    Fo.sham = !0;
    var _o = !Eo || mo((function() {
        var t;
        return xo(xo.call) || !xo(Object) || !xo((function() {
            t = !0
        }
        )) || t
    }
    )) ? Fo : xo
      , Ro = no
      , ko = _o
      , Mo = ut
      , Co = de("species")
      , Do = Array
      , Lo = function(t) {
        var e;
        return Ro(t) && (e = t.constructor,
        (ko(e) && (e === Do || Ro(e.prototype)) || Mo(e) && null === (e = e[Co])) && (e = void 0)),
        void 0 === e ? Do : e
    }
      , Bo = function(t, e) {
        return new (Lo(t))(0 === e ? 0 : e)
    }
      , zo = b
      , No = gt
      , Go = de("species")
      , Ho = function(t) {
        return No >= 51 || !zo((function() {
            var e = [];
            return (e.constructor = {})[Go] = function() {
                return {
                    foo: 1
                }
            }
            ,
            1 !== e[t](Boolean).foo
        }
        ))
    }
      , qo = eo
      , Uo = b
      , Wo = no
      , $o = ut
      , Ko = Vt
      , Qo = vn
      , Vo = function(t) {
        if (t > 9007199254740991)
            throw oo("Maximum allowed index exceeded");
        return t
    }
      , Xo = function(t, e, r) {
        var n = io(e);
        n in t ? uo.f(t, n, co(0, r)) : t[n] = r
    }
      , Yo = Bo
      , Jo = Ho
      , Zo = gt
      , ti = de("isConcatSpreadable")
      , ei = Zo >= 51 || !Uo((function() {
        var t = [];
        return t[ti] = !1,
        t.concat()[0] !== t
    }
    ))
      , ri = Jo("concat")
      , ni = function(t) {
        if (!$o(t))
            return !1;
        var e = t[ti];
        return void 0 !== e ? !!e : Wo(t)
    };
    qo({
        target: "Array",
        proto: !0,
        arity: 1,
        forced: !ei || !ri
    }, {
        concat: function(t) {
            var e, r, n, o, i, u = Ko(this), c = Yo(u, 0), a = 0;
            for (e = -1,
            n = arguments.length; e < n; e++)
                if (ni(i = -1 === e ? u : arguments[e]))
                    for (o = Qo(i),
                    Vo(a + o),
                    r = 0; r < o; r++,
                    a++)
                        r in i && Xo(c, a, i[r]);
                else
                    Vo(a + 1),
                    Xo(c, a++, i);
            return c.length = a,
            c
        }
    });
    var oi = Rt
      , ii = m
      , ui = G(G.bind)
      , ci = function(t, e) {
        return oi(t),
        void 0 === e ? t : ii ? ui(t, e) : function() {
            return t.apply(e, arguments)
        }
    }
      , ai = $
      , fi = Vt
      , li = vn
      , si = Bo
      , pi = G([].push)
      , yi = function(t) {
        var e = 1 == t
          , r = 2 == t
          , n = 3 == t
          , o = 4 == t
          , i = 6 == t
          , u = 7 == t
          , c = 5 == t || i;
        return function(a, f, l, s) {
            for (var p, y, d = fi(a), v = ai(d), h = ci(f, l), b = li(v), g = 0, m = s || si, w = e ? m(a, b) : r || u ? m(a, 0) : void 0; b > g; g++)
                if ((c || g in v) && (y = h(p = v[g], g, d),
                t))
                    if (e)
                        w[g] = y;
                    else if (y)
                        switch (t) {
                        case 3:
                            return !0;
                        case 5:
                            return p;
                        case 6:
                            return g;
                        case 2:
                            pi(w, p)
                        }
                    else
                        switch (t) {
                        case 4:
                            return !1;
                        case 7:
                            pi(w, p)
                        }
            return i ? -1 : n || o ? o : w
        }
    }
      , di = {
        forEach: yi(0),
        map: yi(1),
        filter: yi(2),
        some: yi(3),
        every: yi(4),
        find: yi(5),
        findIndex: yi(6),
        filterReject: yi(7)
    }.filter;
    eo({
        target: "Array",
        proto: !0,
        forced: !Ho("filter")
    }, {
        filter: function(t) {
            return di(this, t, arguments.length > 1 ? arguments[1] : void 0)
        }
    });
    var vi = bo
      , hi = fo ? {}.toString : function() {
        return "[object " + vi(this) + "]"
    }
    ;
    fo || rn(Object.prototype, "toString", hi, {
        unsafe: !0
    });
    var bi = b
      , gi = eo
      , mi = $
      , wi = Z
      , Si = function(t, e) {
        var r = [][t];
        return !!r && bi((function() {
            r.call(null, e || function() {
                return 1
            }
            , 1)
        }
        ))
    }
      , ji = G([].join)
      , Oi = mi != Object
      , Pi = Si("join", ",");
    gi({
        target: "Array",
        proto: !0,
        forced: Oi || !Pi
    }, {
        join: function(t) {
            return ji(wi(this), void 0 === t ? "," : t)
        }
    });
    var Ei = bo
      , Ti = String
      , Ai = function(t) {
        if ("Symbol" === Ei(t))
            throw TypeError("Cannot convert a Symbol value to a string");
        return Ti(t)
    }
      , Ii = "\t\n\v\f\r                　\u2028\u2029\ufeff"
      , xi = X
      , Fi = Ai
      , _i = G("".replace)
      , Ri = "[\t\n\v\f\r                　\u2028\u2029\ufeff]"
      , ki = RegExp("^" + Ri + Ri + "*")
      , Mi = RegExp(Ri + Ri + "*$")
      , Ci = function(t) {
        return function(e) {
            var r = Fi(xi(e));
            return 1 & t && (r = _i(r, ki, "")),
            2 & t && (r = _i(r, Mi, "")),
            r
        }
    }
      , Di = {
        start: Ci(1),
        end: Ci(2),
        trim: Ci(3)
    }
      , Li = v
      , Bi = b
      , zi = G
      , Ni = Ai
      , Gi = Di.trim
      , Hi = Ii
      , qi = Li.parseInt
      , Ui = Li.Symbol
      , Wi = Ui && Ui.iterator
      , $i = /^[+-]?0x/i
      , Ki = zi($i.exec)
      , Qi = 8 !== qi(Hi + "08") || 22 !== qi(Hi + "0x16") || Wi && !Bi((function() {
        qi(Object(Wi))
    }
    )) ? function(t, e) {
        var r = Gi(Ni(t));
        return qi(r, e >>> 0 || (Ki($i, r) ? 16 : 10))
    }
    : qi;
    eo({
        global: !0,
        forced: parseInt != Qi
    }, {
        parseInt: Qi
    }),
    r.default.extend(r.default.fn.bootstrapTable.defaults, {
        treeEnable: !1,
        treeShowField: null,
        idField: "id",
        parentIdField: "pid",
        rootParentId: null
    }),
    r.default.BootstrapTable = function(t) {
        !function(t, e) {
            if ("function" != typeof e && null !== e)
                throw new TypeError("Super expression must either be null or a function");
            t.prototype = Object.create(e && e.prototype, {
                constructor: {
                    value: t,
                    writable: !0,
                    configurable: !0
                }
            }),
            Object.defineProperty(t, "prototype", {
                writable: !1
            }),
            e && u(t, e)
        }(y, t);
        var e, c, f, s = a(y);
        function y() {
            return n(this, y),
            s.apply(this, arguments)
        }
        return e = y,
        c = [{
            key: "init",
            value: function() {
                var t;
                this._rowStyle = this.options.rowStyle;
                for (var e = arguments.length, r = new Array(e), n = 0; n < e; n++)
                    r[n] = arguments[n];
                (t = l(i(y.prototype), "init", this)).call.apply(t, [this].concat(r))
            }
        }, {
            key: "initHeader",
            value: function() {
                for (var t, e = arguments.length, r = new Array(e), n = 0; n < e; n++)
                    r[n] = arguments[n];
                (t = l(i(y.prototype), "initHeader", this)).call.apply(t, [this].concat(r));
                var o = this.options.treeShowField;
                if (o) {
                    var u, c = p(this.header.fields);
                    try {
                        for (c.s(); !(u = c.n()).done; ) {
                            var a = u.value;
                            if (o === a) {
                                this.treeEnable = !0;
                                break
                            }
                        }
                    } catch (t) {
                        c.e(t)
                    } finally {
                        c.f()
                    }
                }
            }
        }, {
            key: "initBody",
            value: function() {
                var t;
                this.treeEnable && (this.options.virtualScroll = !1);
                for (var e = arguments.length, r = new Array(e), n = 0; n < e; n++)
                    r[n] = arguments[n];
                (t = l(i(y.prototype), "initBody", this)).call.apply(t, [this].concat(r))
            }
        }, {
            key: "initTr",
            value: function(t, e, n, o) {
                var u = this
                  , c = n.filter((function(e) {
                    return t[u.options.idField] === e[u.options.parentIdField]
                }
                ));
                o.append(l(i(y.prototype), "initRow", this).call(this, t, e, n, o));
                for (var a = c.length - 1, f = 0; f <= a; f++) {
                    var s = c[f]
                      , p = r.default.extend(!0, {}, t);
                    s._level = p._level + 1,
                    s._parent = p,
                    f === a && (s._last = 1),
                    this.options.rowStyle = function(t, e) {
                        var r = u._rowStyle(t, e)
                          , n = t[u.options.idField] ? t[u.options.idField] : 0
                          , o = t[u.options.parentIdField] ? t[u.options.parentIdField] : 0;
                        return r.classes = [r.classes || "", "treegrid-".concat(n), "treegrid-parent-".concat(o)].join(" "),
                        r
                    }
                    ,
                    this.initTr(s, r.default.inArray(s, n), n, o)
                }
            }
        }, {
            key: "initRow",
            value: function(t, e, r, n) {
                var o = this;
                if (this.treeEnable) {
                	// 这里注释了之后就可以解决id必须为数字的问题
                    var u = t[this.options.parentIdField];//parseInt(t[this.options.parentIdField], 10);
                    return !(this.options.rootParentId !== u && u || (void 0 === t._level && (t._level = 0),
                    this.options.rowStyle = function(t, e) {
                        var r = o._rowStyle(t, e)
                          , n = t[o.options.idField] ? t[o.options.idField] : 0;
                        return r.classes = [r.classes || "", "treegrid-".concat(n)].join(" "),
                        r
                    }
                    ,
                    this.initTr(t, e, r, n),
                    0))
                }
                return l(i(y.prototype), "initRow", this).call(this, t, e, r, n)
            }
        }, {
            key: "destroy",
            value: function() {
                for (var t, e = arguments.length, r = new Array(e), n = 0; n < e; n++)
                    r[n] = arguments[n];
                (t = l(i(y.prototype), "destroy", this)).call.apply(t, [this].concat(r)),
                this.options.rowStyle = this._rowStyle
            }
        }],
        c && o(e.prototype, c),
        f && o(e, f),
        Object.defineProperty(e, "prototype", {
            writable: !1
        }),
        y
    }(r.default.BootstrapTable)
}
));
