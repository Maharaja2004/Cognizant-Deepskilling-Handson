import './App.css';
import Counter from './Components/Counter';
import CurrencyConvertor from './Components/CurrencyConvertor';
import Synthetic from './Components/Synthetic';
import Welcome from './Components/Welcome';

function App() {
  return (
    <div>
      <Counter/>
      <Welcome/><br/>
      <Synthetic/>
      <CurrencyConvertor/>
    </div>
  );
}




export default App;