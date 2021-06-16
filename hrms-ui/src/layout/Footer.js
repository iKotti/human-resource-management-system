import React from "react";

export default function Footer() {
  return (
    <div className="ui footer inverted vertical segment">
      <div className="ui center aligned container">
        <div className="ui stackable inverted divided grid">
          <div className="six wide centered column">
            <button className="ui circular facebook icon button">
              <i className="facebook icon"></i>
            </button>
            <button className="ui circular twitter icon button">
              <i className="twitter icon"></i>
            </button>
            <button className="ui circular linkedin icon button">
              <i className="linkedin icon"></i>
            </button>
            <button className="ui circular google plus icon button">
              <i className="google plus icon"></i>
            </button>
          </div>
        </div>

        <div className="ui inverted section divider"></div>
        <div className="ui horizontal inverted small divided link list">
          <a className="item" href="/#">
            Site Map
          </a>
          <a className="item" href="/#">
            Contact Us
          </a>
          <a className="item" href="/#">
            Terms and Conditions
          </a>
          <a className="item" href="/#">
            Privacy Policy
          </a>
        </div>
      </div>
    </div>
  );
}
