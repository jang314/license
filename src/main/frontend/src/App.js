import './App.css';
import Header from '../src/components/layout/header';
import { Routes, Route } from 'react-router-dom'
import CustLayout from '../src/components/CustLayout';
function App() {
  return (
    <div className="App">
     <Header/>
        <Routes>
            <Route path="/" element={<CustLayout />} />
        </Routes>
    </div>
  );
}

export default App;
