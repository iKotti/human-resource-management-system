import React from "react";

export default function Login() {
  return (
    <div className="auth">
      <div className="authContainer">
          <h1> <i className="user icon"></i> GİRİŞ YAP </h1>
        <form className="ui form">
        <div class="field">
            <label>Email</label>
            <input type="email" name="email" placeholder="Email" />
          </div>
          <div class="field">
            <label>Parola</label>
            <input type="password" name="password" placeholder="Şifre" />
          </div>

          <div class="field">
          <a href="/#">Şifrenizi mi unuttunuz?</a>
            <div class="ui checkbox">
            </div>
          </div>
          <button class="ui blue button" type="submit">
            Giriş Yap
          </button>
        </form>
      </div>
    </div>
  );
}
