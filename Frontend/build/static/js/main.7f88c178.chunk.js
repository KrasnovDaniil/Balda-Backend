(this.webpackJsonpproject_chat_application=this.webpackJsonpproject_chat_application||[]).push([[0],{107:function(e,t){},145:function(e,t,a){},146:function(e,t,a){},147:function(e,t,a){},148:function(e,t,a){},149:function(e,t,a){},150:function(e,t,a){},153:function(e,t,a){"use strict";a.r(t);var n=a(0),c=a.n(n),r=a(59),s=a.n(r),o=a(33),l=a(5),m=a(60),u=a(61),i=a.n(u),A=a(62),E=a.n(A),p=a(63),f=a.n(p),g=(a(145),a(30)),h=a.n(g),j=function(e){var t=e.message,a=t.text,n=t.user,r=e.name,s=!1;return n===r&&(s=!0),s?c.a.createElement("div",{className:"messageContainer justifyEnd"},c.a.createElement("p",{className:"sentText pr-10"},r),c.a.createElement("div",{className:"messageBox backgroundBlue"},c.a.createElement("p",{className:"messageText colorWhite"},h.a.emojify(a)))):c.a.createElement("div",{className:"messageContainer justifyStart"},c.a.createElement("div",{className:"messageBox backgroundLight"},c.a.createElement("p",{className:"messageText colorDark"},h.a.emojify(a))),c.a.createElement("p",{className:"sentText pl-10 "},n))},b=(a(146),function(e){var t=e.messages,a=e.name;return c.a.createElement(f.a,{className:"messages"},t.map((function(e,t){return c.a.createElement("div",{key:t},c.a.createElement(j,{message:e,name:a}))})))}),d=a(64),v=a.n(d),N=a(65),O=a.n(N),C=(a(147),function(e){var t=e.room;return c.a.createElement("div",{className:"infoBar"},c.a.createElement("div",{className:"leftInnerContainer"},c.a.createElement("img",{className:"onlineIcon",src:v.a,alt:"online icon"}),c.a.createElement("h3",null,t)),c.a.createElement("div",{className:"rightInnerContainer"},c.a.createElement("a",{href:"/"},c.a.createElement("img",{src:O.a,alt:"close icon"}))))}),I=(a(148),function(e){var t=e.sendMessage,a=e.message,n=e.saveBoth;return c.a.createElement("form",{name:"inputForm",className:"form"},c.a.createElement("input",{className:"input",type:"text",placeholder:"Type a message...",value:a,onChange:function(e){var t=e.target.value;return n(t)},onKeyPress:function(e){return"Enter"===e.key?t(e):null}}),c.a.createElement("button",{className:"sendButton",onClick:function(e){return t(e)}},"Send"))}),S=function(){var e=Object(n.useState)(!1),t=Object(l.a)(e,2);t[0],t[1]},x=(a(149),function(e){var t=e.location,a=new S,r=Object(n.useState)(""),s=Object(l.a)(r,2),u=s[0],A=s[1],p=Object(n.useState)(""),f=Object(l.a)(p,2),g=f[0],h=f[1],j=Object(n.useState)(""),d=Object(l.a)(j,2),v=(d[0],d[1],Object(n.useState)({text:"qwe",user:""})),N=Object(l.a)(v,2),O=N[0],x=N[1],y=Object(n.useState)(""),B=Object(l.a)(y,2),R=B[0],k=B[1],w=Object(n.useState)([]),U=Object(l.a)(w,2),M=U[0],Q=U[1];Object(n.useEffect)((function(){var e=i.a.parse(t.search),n=e.name,c=e.room;Object(m.a)("socket"),a=E()("http://localhost:8080"),h(c),A(n),a.connect();var r={text:"Hello ".concat(n),user:"admin"};Q((function(e){return[].concat(Object(o.a)(e),[r])}))}),["http://localhost:8080",t.search]);return c.a.createElement("div",{className:"outerContainer"},c.a.createElement("div",{className:"container"},c.a.createElement(C,{room:g}),c.a.createElement(b,{messages:M,name:u}),c.a.createElement(I,{message:R,sendMessage:function(e){e.preventDefault(),R&&(Q((function(e){return[].concat(Object(o.a)(e),[O])})),k((function(){return""})),a.sendMessage(R))},saveBoth:function(e){k(e),x((function(){return{text:e,user:u}}))}})))}),y=a(17);a(150);function B(){var e=Object(n.useState)(""),t=Object(l.a)(e,2),a=t[0],r=t[1],s=Object(n.useState)(""),o=Object(l.a)(s,2),m=o[0],u=o[1];return c.a.createElement("div",{className:"joinOuterContainer"},c.a.createElement("div",{className:"joinInnerContainer"},c.a.createElement("h1",{className:"heading"},"Join"),c.a.createElement("div",null,c.a.createElement("input",{placeholder:"Name",className:"joinInput",type:"text",onChange:function(e){return r(e.target.value)}})),c.a.createElement("div",null,c.a.createElement("input",{placeholder:"Room",className:"joinInput mt-20",type:"text",onChange:function(e){return u(e.target.value)}})),c.a.createElement(y.b,{onClick:function(e){return a&&m?null:e.preventDefault()},to:"/chat?name=".concat(a,"&room=").concat(m)},c.a.createElement("button",{className:"button mt-20",type:"submit"},"Sign In"))))}var R=a(1),k=function(){return c.a.createElement(y.a,null,c.a.createElement(R.a,{path:"/",exact:!0,component:B}),c.a.createElement(R.a,{path:"/chat",component:x}))};s.a.render(c.a.createElement(k,null),document.getElementById("root"))},64:function(e,t){e.exports="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAYAAAAGCAYAAADgzO9IAAAAAXNSR0IArs4c6QAAAExJREFUCB1jbPh/le3lx5tNDIwMcQwg8J9hkTi/eh0LWJCBoRwoAAPlQDEGJrhKmDCIBupmQuYjs5lAZiILgNlAMRaQRSAz4UZCLQcAIwYaiAejKoYAAAAASUVORK5CYII="},65:function(e,t){e.exports="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAYAAACNMs+9AAAAAXNSR0IArs4c6QAAAHBJREFUGBmNkAEKwCAMA2VfGP2mrx3sOV2us6IymIXQGlNTW9zdhCqcZQm4dmelFUp+CZZa6sYpeUVIFyIixMqjCO51Wy5unQExuYSbSF5JASLqPsqRM21lOoWc89tagr3PSMgOiWlwnUeXWA/E78IfuAX270S3ydAAAAAASUVORK5CYII="},67:function(e,t,a){e.exports=a(153)}},[[67,1,2]]]);
//# sourceMappingURL=main.7f88c178.chunk.js.map