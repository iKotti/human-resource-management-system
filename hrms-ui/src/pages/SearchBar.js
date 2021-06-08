import React from "react";
import { Container } from "semantic-ui-react";

export default function SearchBar() {

  return (
    <div className="searchContainer">
        <Container>
        <h2> HRMS Sistemine hoşgeldin, hemen kendine uygun iş ilanlarına ulaşabilirsin. </h2>
        <form>
        <div class="ui icon input">
          <input
            class="prompt"
            type="text"
            placeholder="İş pozisyonları arasında ara..."
          ></input>
          <i class="search icon"></i>
        </div>
        <div class="ui icon input">
          <input
            class="prompt"
            type="text"
            placeholder="Şehir adı..."
          ></input>
          <i class="search icon"></i>
        </div>
      </form>
        </Container>
    </div>
  );
}
