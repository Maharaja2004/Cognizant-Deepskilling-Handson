import image from './office.jpg';
import './App.css';


function App() {

  const heading="Office Space";
const img=<img src={image} height="25%"  width="25%"/>
const Office={name:"DBS",
              rent:5000,
              address:"Chennai"};
const colors=(Office.rent<=6000)?{color:"red"}:{color:"green"};




  return (
    <div style={{textAlign:'center'}}>
       <h1>{heading} , at Affordable Range</h1>
       {img}
       <h1>Name:{Office.name}</h1>
       <h2 style={colors}>Rent: Rs.{Office.rent}</h2>
       <h3>Address: {Office.address}</h3>
    </div>
  );
}

export default App;
