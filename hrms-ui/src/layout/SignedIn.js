import React from "react";
import { Link } from "react-router-dom";
import { Dropdown, Image } from "semantic-ui-react";

export default function SignedIn({ signOut }) {
  return (
    <div>
      <Link className="ui small primary button" to="/addjobposting" style={{marginRight:"1.3em"}}>
        İlan Ekle
      </Link>
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
