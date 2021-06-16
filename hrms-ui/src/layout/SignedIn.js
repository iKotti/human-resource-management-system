import React from "react";
import { Dropdown, Image } from "semantic-ui-react";

export default function SignedIn({ signOut }) {
  return (
    <div>
      <button className="ui small primary button" style={{marginRight:"1.3em"}}>
        İlan Ekle
      </button>
      <Image
        avatar
        spaced="right"
        src="https://avatars.githubusercontent.com/u/58571709?v=4"
      />
      <Dropdown pointing="top left" text="İlker">
        <Dropdown.Menu>
          <Dropdown.Item text="Bilgilerim" icon="info" />
          <Dropdown.Item onClick={signOut} text="Çıkış Yap" icon="sign-out" />
        </Dropdown.Menu>
      </Dropdown>
    </div>
  );
}
