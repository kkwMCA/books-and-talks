import Post from "../post/Post";
import Share from "../share/Share";
import "./feed.css";
// import { Posts } from "../../dummyData";
import React, { useState, useEffect } from "react";
import axios from "axios";

const baseURL = "http://localhost:8081/getAllPost";
export default function Feed() {

  const [data, setData] = useState(null);
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState(null);
  const fetchData = async () => {
    setIsLoading(true);
    try {
      const response = await axios.get(baseURL);
      setData(response.data);
    } catch (error) {
      setError(error);
    } finally {
      setIsLoading(false);
    }
  };

  useEffect(() => {
    fetchData();
  }, []);

  if (isLoading) return <div>Loading...</div>;

  if (error) return <div>Error: {error.message}</div>;

  if (!data) return null;
  function traverse_it(obj){
    for(var prop in obj){
        if(typeof obj[prop]=='object'){
            // object
            traverse_it(obj[prop[i]]);
        }else{
            // something else
            alert('The value of '+prop+' is '+obj[prop]+'.');
        }
    }
}
  console.log(traverse_it(data))
  return (
    
    <div>
      <h1>Name: {data.postname}</h1>
    </div>
  );
  
};
// axios({
//   method: "post",
//   url: "http://localhost:8093/send",
//   data: newContact,
//   headers: { "Content-Type": "application/json" },

// })
//   .then((response) => {
//     // setResponse(response.data)
//     console.log(response.data, 'from post method')
//   })
//   .catch(function (error) {
//     console.log(error, 'this is Error');
//     // console.log(JSON.stringify(newContact));
//   });
  // return (
  //   <div className="feed">
  //     <div className="feedWrapper">
  //       <Share />
  //       <p>data.postname</p>
  //     </div>
  //   </div>
  // );
{
{},{}
}