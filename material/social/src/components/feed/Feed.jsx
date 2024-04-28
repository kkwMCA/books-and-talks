import Post from "../post/Post";
import Share from "../share/Share";
import "./feed.css";
// import { Posts } from "../../dummyData";
import React, { useState, useEffect } from "react";
import axios from "axios";

export default function Feed() {
  const [posts, setPosts] = useState([]);
  // const [text, setText] = useState("");


  useEffect(() => {
    const fetchPosts = async () => {
      const res = await axios.get("http://localhost:8081");
      setPosts(res.data)
    };
    fetchPosts();
  }, []);

return (
   <div className="feed">
       {/* <input type="text" onChange={e =>setText(e.target.value)} /> */}
       <div className="feedWrapper">
         <Share />
         {posts.map((p) => (
          <Post key={p.id} post={p} />
        ))}
      </div>
    </div>
  );
}

// export default Feed;















{/* 
function App() {
  const url = "http://localhost:8081";
  const [data, setData] = useState([]);

  const fetchInfo = () => {
    return fetch(url)
      .then((res) => res.json())
      .then((d) => setData(d))
  }


  useEffect(() => {
    fetchInfo();
  }, []);

export default function Feed() {
  return (
    <div className="feed">
      <div className="feedWrapper">
        <Share />
        {Posts.map((p) => (
          <Post key={p.id} post={p} />
        ))}
      </div>
    </div>
  );
} */}
