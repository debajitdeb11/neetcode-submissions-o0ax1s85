public class LRUCache {
    private readonly LinkedList<(int key, int value)> _cache;
    private readonly Dictionary<int, LinkedListNode<(int key, int value)>> _map;
    private readonly int _capacity;

    public LRUCache(int capacity) {
        _capacity = capacity;
        _map = new Dictionary<int, LinkedListNode<(int key, int value)>>();
        _cache = new LinkedList<(int key, int value)>();
    }
    
    public int Get(int key) {
        if (_map.ContainsKey(key))
        {
            LinkedListNode<(int key, int value)> node = _map[key];
            _cache.Remove(node);

            LinkedListNode<(int key, int value)> newNode = new LinkedListNode<(int key, int value)>((key, node.Value.value));

            _cache.AddFirst(newNode);
            _map[key] = newNode;

            return newNode.Value.value;
        }
        
        return -1;
    }
    
    public void Put(int key, int value) {
        if (_map.ContainsKey(key))
        {
            LinkedListNode<(int key, int value)> node = _map[key];

            // Remove from current position
            _cache.Remove(node);
            _map.Remove(key);
        }
        else
        {
            if (_map.Count == _capacity)
            {
                LinkedListNode<(int key, int value)> node = _cache.Last;
                _cache.RemoveLast();
                _map.Remove(node.Value.key);
            }
        }

        LinkedListNode<(int key, int value)> newNode = new LinkedListNode<(int key, int value)>((key, value));

        _cache.AddFirst(newNode);
        _map[key] = newNode;
    }
}