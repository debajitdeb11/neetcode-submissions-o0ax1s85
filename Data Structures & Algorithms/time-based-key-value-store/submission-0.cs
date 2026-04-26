public class TimeMap {
    private readonly Dictionary<string, PriorityQueue<(string, int), int>> _store;
    // private readonly SemaphoreSlim semaphore = new(1);
    
    public TimeMap()
    {
        _store = new Dictionary<string, PriorityQueue<(string, int), int>>();
    }

    public void Set(string key, string value, int timestamp)
    {
        try
        {
            // Acquire the semaphore
            // semaphore.WaitAsync();
            
            if (!_store.ContainsKey(key))
            {
                // initialize a new PQ
                _store.TryAdd(
                    key,
                    new PriorityQueue<(string, int), int>(
                        Comparer<int>
                            .Create(
                                (i1, i2) => i1.CompareTo(i2)
                                )));
            }
            
            _store[key].Enqueue((value, timestamp), timestamp);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
        }
        finally
        {
            // Release the semaphore
            // semaphore.Release();
        }
    }

    public string Get(string key, int timestamp)
    {
        if (!_store.ContainsKey(key))
        {
            return "";
        }

        List<(string, int)> temp = new List<(string, int)>();

        string result = "";
        
        while (_store[key].Count > 0)
        {
            var item = _store[key].Dequeue();
            
            temp.Add(item);
            
            if (item.Item2 <= timestamp)
            {
                result = item.Item1;
            }
        }
        
        // Re-queue those items;
        foreach (var item in temp)
        {
            _store[key].Enqueue(item, item.Item2);
        }

        return result;
    }
}
