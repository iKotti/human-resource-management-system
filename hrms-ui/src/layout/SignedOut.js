import React from "react";

export default function SignedOut({signIn}) {
  return (
    <div>
      <button className="ui small gray button" onClick={signIn}>
        <i className="icon user"></i>
        Giriş Yap
      </button>
      <button className="ui small green button">
        <i className="icon user plus "></i>
        Kayıt Ol
      </button>
    </div>
  );
}
