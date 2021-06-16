import React from "react";

export default function Login() {
  return (
    <div className="auth">
      <div className="authContainer">
          <h1> <i className="user icon"></i> GİRİŞ YAP </h1>
        <form className="ui form">
        <div className="field">
            <label>Email</label>
            <input type="email" name="email" placeholder="Email" />
          </div>
          <div className="field">
            <label>Parola</label>
            <input type="password" name="password" placeholder="Şifre" />
          </div>

          <div className="field">
          <a href="/#">Şifrenizi mi unuttunuz?</a>
            <div className="ui checkbox">
            </div>
          </div>
          <button className="ui blue button" type="submit">
            Giriş Yap
          </button>
        </form>
      </div>
    </div>
  );
}
