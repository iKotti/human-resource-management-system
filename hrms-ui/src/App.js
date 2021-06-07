import "./App.css";
import "semantic-ui-css/semantic.min.css";
import Navbar from "./layout/Navbar";
import { Container } from "semantic-ui-react";
import Dashboard from "./layout/Dashboard";

function App() {
  return (
    <div className="App">
      <Navbar />

      <Container className="main">
        <Dashboard></Dashboard>
      </Container>
    </div>
  );
}

export default App;
