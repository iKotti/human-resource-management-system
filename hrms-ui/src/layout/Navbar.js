import React,{useState} from "react";
import { Link,useHistory } from "react-router-dom";
import { Menu, Segment, Container, Icon } from "semantic-ui-react";
import SignedOut from "./SignedOut";
import SignedIn from "./SignedIn";

export default function Navbar() {
  const [isAuthenticated, setIsAuthenticated] = useState(true)
  const history = useHistory()

  function handleSignOut() {
    setIsAuthenticated(false)
    history.push("/")
  }

  function handleSignIn() {
    setIsAuthenticated(true)
  }

  return (
    <div>
      <Segment inverted>
        <Menu inverted>
          <Container>
            <Menu.Item name="icon" as={Link} to="/">
              <Icon name="suitcase" size="large" /> HRMS
            </Menu.Item>
            <Menu.Item name="İş İlanları" as={Link} to="/jobpostings"/>
            <Menu.Item name="İş Pozisyonları" as={Link} to="/jobpositions" />
            <Menu.Menu position="right">
              {
                isAuthenticated?<SignedIn signOut={handleSignOut}/>:<SignedOut signIn={handleSignIn}/>
              }
            </Menu.Menu>
          </Container>
        </Menu>
      </Segment>
    </div>
  );
}
