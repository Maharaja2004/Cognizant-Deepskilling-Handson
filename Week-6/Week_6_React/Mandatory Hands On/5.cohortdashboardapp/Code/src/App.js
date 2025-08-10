import React from 'react';
import CohortDetails from './Components/CohortDetails';
import { CohortsData} from './Cohort';
function App() {
 
  return (
  <div>
    <h1>Cohorts Details</h1>
    {CohortsData.map(cohort => <CohortDetails cohort={cohort}/>)}
  </div>
  );
}


export default App;
