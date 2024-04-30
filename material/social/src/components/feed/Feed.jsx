// import Post from "../post/Post";
// import Share from "../share/Share";
import "./feed.css";
// import { Posts } from "../../dummyData";
import React, { useState, useEffect } from "react";
import axios from "axios";

const baseURL = "http://localhost:8081/api/get";
export default function Feed() {

  const [data, setData] = useState(null);
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState(null);

  const [file, setFile] = useState(null);
  const [desc, setDesc] = useState(null);
  const [postname, setPostName] = useState(null);

  const [like, setLike] = useState(null);
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
  

  console.log(data.post)
  
  function handleForm(e) {
    e.preventDefault();

    const data = new FormData();
    data.append("image", file);
    data.append("postname",postname);
    data.append("desc",desc)

    fetch("http://localhost:8081/post", {
      method: "POST",
      body: data,
    });
  }

  function handleLikes(e) {
    e.preventDefault();

    const data = new FormData();
    data.append("id", like);

    fetch("http://localhost:8081/like", {
      method: "POST",
      body: data,
    });
  }

  function handleFileChange(e) {
    if (e.target.files && e.target.files[0]) setFile(e.target.files[0]);
  }
  return (
    
    <div>
   
    <form >
    <input type="text" placeholder="enter your postname"  onChange={(e) => {setPostName(e.target.value)}} value ={postname} required />
    <input type="text" placeholder="enter your description"  onChange={(e) => {setDesc(e.target.value)}} value ={desc} required />
    <input type="file" name="image" onChange={handleFileChange} />
    <button type="submit" onClick={(e) => handleForm(e)}>
          Submit
        </button>
    </form>
    <hr>
    </hr>
    {data.slice().reverse().map((post, index) => (// Use map for array iteration
      <div key={index}>  
        <p><strong>sumedh</strong></p>
        <h5>{post.postname}</h5>
      
        <img src={`data:image/jpeg;base64, ${post.img}`} ></img>
        <p><i>description: {post.description}</i> </p>
        <form >
        <button type="submit" name="id" value={post.likes} onClick={(e) => handleLikes(e)}>
          Likes
        </button><p>{post.likes}</p>
    </form>
      </div>
    ))}
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
