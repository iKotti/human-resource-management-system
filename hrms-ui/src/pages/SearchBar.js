import React from "react";
import { Container } from "semantic-ui-react";

export default function SearchBar() {

  return (
    <div className="searchContainer">
        <Container>
        <h2> HRMS Sistemine hoşgeldin, hemen kendine uygun iş ilanlarına ulaşabilirsin. </h2>
        <form>
        <div className="ui icon input">
          <input
            className="prompt"
            type="text"
            placeholder="İş pozisyonları arasında ara..."
          ></input>
          <i className="search icon"></i>
        </div>
        <div className="ui icon input">
          <input
            className="prompt"
            type="text"
            placeholder="Şehir adı..."
          ></input>
          <i className="search icon"></i>
        </div>
      </form>
        </Container>
    </div>
  );
}
