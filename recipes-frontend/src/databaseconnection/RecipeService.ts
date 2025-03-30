export const fetchRecipes = async (name: string, ids: number[]) => {
    const params = new URLSearchParams();
  
    if (ids.length > 0) {
      params.append('categoryIds', ids.join(',')); // IDs durch Komma getrennt
    }
  
    if (name) {
      params.append('name', name);
    }
  
    try {
      const response = await fetch(`http://localhost:8080/recipe?${params.toString()}`, {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
        },
      });
  
      if (!response.ok) {
        throw new Error('Error fetching recipes');
      }
  
      const data = await response.json();
      return data;
    } catch (error) {
      console.error(error);
      throw error;
    }
  };
  