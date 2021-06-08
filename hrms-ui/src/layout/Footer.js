import React from "react";

export default function Footer() {
  return (
    <div className="ui footer inverted vertical segment">
      <div className="ui center aligned container">
        <div className="ui stackable inverted divided grid">
          <div className="six wide centered column">
            <button class="ui circular facebook icon button">
              <i class="facebook icon"></i>
            </button>
            <button class="ui circular twitter icon button">
              <i class="twitter icon"></i>
            </button>
            <button class="ui circular linkedin icon button">
              <i class="linkedin icon"></i>
            </button>
            <button class="ui circular google plus icon button">
              <i class="google plus icon"></i>
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
