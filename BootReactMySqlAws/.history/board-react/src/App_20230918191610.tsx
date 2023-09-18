import React from 'react';
import logo from './logo.svg';
import './App.css';

function App() {
  const [connection, setConnect] = useState<string>('');
  const connectionTest = ()=>{
    axios.get();
  }
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
       
      </header>
    </div>
  );
}

export default App;
